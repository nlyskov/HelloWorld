package MyLibrary.Service;

import MyLibrary.Model.Book;

import java.util.List;

public interface BookService {
    List<String> getAllBooksName();
    String getBookNameById(Integer id);
    Book addBook(Book book);
}
