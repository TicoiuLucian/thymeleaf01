package ro.itschool.service;

import ro.itschool.controller.model.AuthorDTO;
import java.util.List;
import java.util.Optional;

public interface AuthorService {

  List<AuthorDTO> getAllAuthors();

  void deleteAuthor(Integer id);

  void save(AuthorDTO author);

  Optional<AuthorDTO> findById(final Integer id);
}