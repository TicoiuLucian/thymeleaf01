package ro.itschool.mapper;

import org.mapstruct.Mapper;
import ro.itschool.controller.model.JokeDTO;
import ro.itschool.entity.Joke;

@Mapper(componentModel = "spring")
public interface JokeMapper {

  JokeDTO entityToDTO(Joke joke);

  Joke DTOToEntity(JokeDTO jokeDTO);
}