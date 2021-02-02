package MyLibrary.Shell;

import MyLibrary.Model.Book;
import MyLibrary.Service.BookService;
import MyLibrary.Service.Impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommandList {
    private BookService service = new BookServiceImpl();

    @ShellMethod(value = "Show all books", key = {"show", "showBooks"})
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }
}