package ro.itschool.mapper;


import org.mapstruct.Mapper;
import ro.itschool.controller.model.AuthorDTO;
import ro.itschool.controller.model.JokeDTO;
import ro.itschool.entity.Author;
import ro.itschool.entity.Joke;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDTO entityToDTO(Author author);

    Author DTOToEntity(AuthorDTO authorSaveRequestDTO);
}
