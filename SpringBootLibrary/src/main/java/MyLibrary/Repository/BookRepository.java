package MyLibrary.Repository;

import MyLibrary.Entity.Author;
import MyLibrary.Entity.Book;
import MyLibrary.Entity.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findAll();
    List<Book> findByAuthor(Author author);

    @Query("select b.name from Book b")
    List<String> getAllBooksName();

}
