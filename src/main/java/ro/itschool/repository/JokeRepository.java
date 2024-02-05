package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Joke;

public interface JokeRepository extends JpaRepository<Joke, Integer> {
}
