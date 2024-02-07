package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
