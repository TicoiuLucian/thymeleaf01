package ro.itschool.mapper;

import org.mapstruct.Mapper;
import ro.itschool.controller.model.AuthorDTO;
import ro.itschool.controller.model.JokeDTO;
import ro.itschool.entity.Author;
import ro.itschool.entity.Joke;

@Mapper(componentModel = "spring")
public interface JokeMapper {

//  AuthorDTO entityToDTO(Author author);

  JokeDTO entityToDTO(Joke joke);

  Joke DTOToEntity(JokeDTO jokeSaveRequestDTO);

}
