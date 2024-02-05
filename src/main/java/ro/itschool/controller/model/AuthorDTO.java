package ro.itschool.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AuthorDTO {

  private Integer id;

  private String lastName;

  private String firstName;

}
