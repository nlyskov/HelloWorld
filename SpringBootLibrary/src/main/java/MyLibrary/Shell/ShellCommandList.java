package MyLibrary.Shell;

import MyLibrary.Entity.Author;
import MyLibrary.Entity.Book;
import MyLibrary.Entity.Genre;
import MyLibrary.Repository.AuthorRepository;
import MyLibrary.Repository.BookRepository;
import MyLibrary.Repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import lombok.*;
import java.util.Scanner;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommandList {

    Scanner s = new Scanner(System.in);

    // Подключаем репозитории
    @Autowired
    private BookRepository book_repo;

    @Autowired
    private AuthorRepository author_repo;

    @Autowired
    private GenreRepository genre_repo;


    // Работа с сущностью Book
    @ShellMethod(value = "Show all books", key = {"show", "showBooks"})
    public List<Book> findAll() {
        return book_repo.findAll();
    }

    @ShellMethod(value = "Show all name books", key = {"shown", "showBooksName"})
    public List<String> getAllBooksName() {
        return book_repo.getAllBooksName();
    }

    @ShellMethod(value = "Find all books by author", key = {"find", "findByAuthor"})
    public List<Book> findByAuthor(String name) {
        return book_repo.findByAuthor(author_repo.findByName(name));
    }

    @ShellMethod(value = "Add new book", key = {"addb", "addBook"})
    public void  addBook() {
        System.out.println("Введите информацию о книге: ");
        System.out.println("Введите название: ");
        String name = s.next();
        System.out.println("Введите автора: ");
        String author = s.next();
        System.out.println("Введите жанр: ");
        String genre = s.next();
        //book_repo.save(new Book(name, author_repo.save(new Author(author)), genre_repo.findByName(genre)));
        book_repo.save(new Book(
                name,
                author_repo.existsByName(author) ? author_repo.findByName(author) : author_repo.save(new Author(author)),
                genre_repo.existsByName(genre) ? genre_repo.findByName(genre) : genre_repo.save(new Genre(genre))));
    }

    // Работа с сущностью Author
    @ShellMethod(value = "Add new author", key = {"adda", "addAuthor"})
    public void addAuthor() {
        System.out.println("Введите фамилию автора, которого хотите добавить: ");
        String author_name = s.next();
        Boolean result = author_repo.existsByName(author_name);
        if (result) {
            System.out.println("Такой автор уже есть в таблице!");
        }
        else {
            author_repo.save(new Author(author_name));
        }
    }

    @ShellMethod(value = "Show all authors", key = {"showa", "showAuthors"})
    public List<Author> showAuthors() {
        return author_repo.findAll();
    }

    @ShellMethod(value = "Find by name", key = {"finda", "findAuthor"})
    public Author findByName() {
        System.out.println("Введите фамилию автор, которого нужно найти: ");
        String author_name = s.next();
        return author_repo.findByName(author_name);
    }

    // Работа с сущностью Genre
    @ShellMethod(value = "Add new genre", key = {"addg", "addGenre"})
    public void addGenre() {
        System.out.println("Введите жанр, которого хотите добавить: ");
        String genre_name = s.next();
        Boolean result = genre_repo.existsByName(genre_name);
        if (result) {
            System.out.println("Такой жанр уже существует!");
        }
        else {
            genre_repo.save(new Genre(genre_name));
        }
    }

    @ShellMethod(value = "Show all genres", key = {"showg", "showGenres"})
    public List<Genre> showGenres() {
        return genre_repo.findAll();
    }




}