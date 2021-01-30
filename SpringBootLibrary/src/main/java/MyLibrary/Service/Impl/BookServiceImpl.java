package MyLibrary.Service.Impl;

import MyLibrary.Dao.BookDao;
import MyLibrary.Dao.Impl.BookDaoImpl;
import MyLibrary.Model.Book;
import MyLibrary.Service.BookService;

import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public List<String> getAllBooksName() {
        return bookDao.getAllBooks().stream()
                .map(Book::getName)
                .collect(Collectors.toList());
    }

    @Override
    public String getBookNameById(Integer id) {
        return bookDao.getById(id)
                .map(Book::getName)
                .orElse("не найдено");
    }

    @Override
    public Book addBook(Book book) {
        bookDao.addBook(book);
        return null;
    }
}
