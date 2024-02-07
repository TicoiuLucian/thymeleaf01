package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.itschool.entity.Joke;

import java.util.List;

public interface JokeRepository extends JpaRepository<Joke, Integer> {
    @Query("SELECT j FROM Joke j WHERE " +
            "LOWER(j.setup) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(j.punchline) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(j.author.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(j.author.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))"
    )
    List<Joke> findByKeyword(@Param("keyword") String keyword);
}