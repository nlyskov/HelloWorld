package MyLibrary.Dao;

import MyLibrary.Model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    List<Book> getAllBooks();
}
