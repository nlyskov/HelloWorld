package MyLibrary.Repository;

import MyLibrary.Entity.Author;
import MyLibrary.Entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    Optional<Author> findById(Integer id);
    List<Author> findAll();
    Author findByName(String name);
    Boolean existsByName(String name);
}
