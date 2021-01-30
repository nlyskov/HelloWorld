package MyLibrary.Shell;

import MyLibrary.Model.Book;
import MyLibrary.Service.BookService;
import MyLibrary.Service.Impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import java.util.Scanner;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommandList {
    private BookService service = new BookServiceImpl();

    @ShellMethod(value = "Show all books", key = {"show", "showBooks"})
    public List<String> getAllBooksName() {
        return service.getAllBooksName();
    }

    @ShellMethod(value = "Add book", key = {"add", "addBook"})
    public Book addBook() {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите информацию о книге: ");
        System.out.println("Введите номер: ");
        int id = s.nextInt();
        System.out.println("Введите название: ");
        String name = s.next();
        System.out.println("Введите автора: ");
        String author = s.next();
        System.out.println("Введите жанр: ");
        String genre = s.next();
        return service.addBook(new Book(id, name, author, genre));
    }
}