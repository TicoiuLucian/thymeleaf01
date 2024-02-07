package ro.itschool.service;

import ro.itschool.controller.model.AuthorDTO;
import ro.itschool.controller.model.JokeDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<JokeDTO> getAuthors();

    void deleteAuthor(Integer id);

    void save(AuthorDTO authorDTO);

    void getAuthors(final int count);

    Optional<AuthorDTO> findById(Integer id);
}
