package ro.itschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.itschool.controller.model.AuthorDTO;
import ro.itschool.controller.model.JokeDTO;
import ro.itschool.mapper.AuthorMapper;
import ro.itschool.mapper.JokeMapper;
import ro.itschool.repository.AuthorRepository;
import ro.itschool.repository.JokeRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    public static final String RANDOM_JOKE_URL = "https://official-joke-api.appspot.com/random_joke";
    private final RestTemplate restTemplate;
    private final ExecutorService executorService;

    @Override
    public List<JokeDTO> getAuthors() {
        return null;
    }

    @Override
    public void deleteAuthor(Integer id) {

    }

    @Override
    public void save(final AuthorDTO author) {
        authorRepository.save(authorMapper.DTOToEntity(author));
    }

    @Override
    public void getAuthors(int count) {

    }

    @Override
    public Optional<AuthorDTO> findById(Integer id) {
        return Optional.empty();
    }
}
