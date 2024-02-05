package ro.itschool.service;

import ro.itschool.controller.model.JokeDTO;

import java.util.List;
import java.util.Optional;

public interface JokeService {

  List<JokeDTO> getJokes();

  void deleteJoke(Integer id);

  void save(JokeDTO joke);

  void getJokes(final int count);

  Optional<JokeDTO> findById(Integer id);
}
