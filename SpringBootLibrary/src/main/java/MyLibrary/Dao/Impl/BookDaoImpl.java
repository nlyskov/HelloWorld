package MyLibrary.Dao.Impl;

import MyLibrary.Dao.BookDao;
import MyLibrary.Model.Book;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookDaoImpl implements BookDao {
    private final List<Book> books;

    private final Map<Integer, Book> bookMap;

    public BookDaoImpl() {
        this.books = new ArrayList<>();
        books.add(new Book(1, "Война и Мир", "Толстой",  "Роман"));
        books.add(new Book(2, "Герой нашего времени", "Лермонтов",  "Приключения"));
        books.add(new Book(3, "Преступление и наказание", "Достоевский",  "Боевик"));

        bookMap = books.stream()
                .collect(Collectors.toMap(Book::getId, Function.identity()));
    }

    @Override
    public List<Book> getAllBooks() {
        return Collections.unmodifiableList(books);
    }

    @Override
    public Optional<Book> getById(Integer id) {
        Book book = null;
        for (Book item : books){
            if (id.equals(item.getId())){
                book = item;
                break;
            }
        }
        return Optional.ofNullable(book);
    }

    @Override
    public Book addBook(Book book) {
        books.add(book);
        return null;
    }
}
