package ro.itschool.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.itschool.controller.model.JokeDTO;
import ro.itschool.entity.Author;
import ro.itschool.entity.Joke;
import ro.itschool.mapper.JokeMapper;
import ro.itschool.repository.AuthorRepository;
import ro.itschool.repository.JokeRepository;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Service
@RequiredArgsConstructor
public class JokeServiceImpl implements JokeService {
  private final JokeRepository jokeRepository;
  private final AuthorRepository authorRepository;
  private final JokeMapper jokeMapper;
  public static final String RANDOM_JOKE_URL = "https://official-joke-api.appspot.com/random_joke";
  private final RestTemplate restTemplate;
  private final ExecutorService executorService;

  @Override
  public List<JokeDTO> getJokes() {
    return jokeRepository.findAll().stream()
            .map(jokeMapper::entityToDTO)
            .toList();
  }

  @Override
  public void deleteJoke(final Integer id) {
    jokeRepository.deleteById(id);
  }

  @Transactional
  public void save(JokeDTO jokeDTO) {
    if (jokeDTO.getAuthor() != null && jokeDTO.getAuthor().getId() != null) {
      Author author = authorRepository.findById(jokeDTO.getAuthor().getId())
              .orElseThrow(() -> new IllegalArgumentException("Invalid Author ID: " + jokeDTO.getAuthor().getId()));
      Joke joke = jokeMapper.DTOToEntity(jokeDTO);
      joke.setAuthor(author);
      jokeRepository.save(joke);
    }
  }

  public void getJokes(final int count) {
    int batches = count / 10 + (count % 10 > 0 ? 1 : 0);
    List<Joke> jokes = new ArrayList<>();
    for (int i = 0; i < batches; i++) {
      int finalI = i;
      CompletableFuture<List<Joke>> jokeBatch = CompletableFuture.supplyAsync(() -> {
        List<Joke> batch = new ArrayList<>();
        for (int j = 0; j < 10 && (finalI * 10 + j) < count; j++) {
          Optional<Joke> joke;
          joke = Optional.ofNullable(restTemplate.getForObject(RANDOM_JOKE_URL, Joke.class));
          joke.ifPresent(batch::add);
        }
        return batch;
      }, executorService);

      jokes.addAll(jokeBatch.join());
    }
    Author author1 = new Author();
    author1.setFirstName("firstName1");
    author1.setLastName("lastName1");
    author1.addJokes(jokes.stream().limit(10).toList());

    Author author2 = new Author();
    author2.setFirstName("firstName2");
    author2.setLastName("lastName2");
    author2.addJokes(jokes.stream().skip(10).limit(10).toList());

    Author author3 = new Author();
    author3.setFirstName("firstName3");
    author3.setLastName("lastName3");
    author3.addJokes(jokes.stream().skip(20).limit(10).toList());
    jokeRepository.saveAll(jokes);

  }

  @Override
  public Optional<JokeDTO> findById(final Integer id) {
    var optionalJoke = jokeRepository.findById(id);
    return optionalJoke.map(jokeMapper::entityToDTO);
  }

  @Override
  public List<JokeDTO> findByKeyword(String searchQuery) {
    List<Joke> jokeSearchResults = jokeRepository.findByKeyword(searchQuery);
      return jokeSearchResults.stream()
              .map(jokeMapper::entityToDTO)
              .toList();
  }
}