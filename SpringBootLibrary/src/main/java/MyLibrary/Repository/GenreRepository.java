package MyLibrary.Repository;

import MyLibrary.Entity.Author;
import MyLibrary.Entity.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
    Optional<Genre> findById(Integer id);
    Genre findByName(String name);
    Boolean existsByName(String name);
    List<Genre> findAll();
}
