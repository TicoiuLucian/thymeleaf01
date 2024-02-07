package ro.itschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.itschool.controller.model.AuthorDTO;
import ro.itschool.entity.Author;
import ro.itschool.mapper.AuthorMapper;
import ro.itschool.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository authorRepository;
  private final AuthorMapper authorMapper;

  @Override
  public List<AuthorDTO> getAllAuthors() {
    return authorRepository.findAll().stream()
            .map(authorMapper::entityToDTO)
            .toList();
  }

  @Override
  public void deleteAuthor(Integer id) {
    authorRepository.deleteById(id);
  }

  @Override
  public void save(AuthorDTO author) {
    authorRepository.save(authorMapper.DTOToEntity(author));
  }

  @Override
  public Optional<AuthorDTO> findById(final Integer id) {
    return authorRepository.findById(id)
            .map(authorMapper::entityToDTO);
  }
}
