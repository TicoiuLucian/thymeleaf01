package ro.itschool.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class JokeDTO {

  private Integer id;

  private String setup;

  private String punchline;

  private AuthorDTO author;
}
