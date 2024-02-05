package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String firstName;

  private String lastName;

  @OneToMany(mappedBy = "author")
  @ToString.Exclude
  private List<Joke> jokes = new ArrayList<>();

  public void addJoke(Joke joke) {
    jokes.add(joke);
    joke.setAuthor(this);
  }

  public void addJokes(List<Joke> jokes) {
    jokes.forEach(joke -> {
      joke.setAuthor(this);
      this.jokes.add(joke);
    });
  }
}
