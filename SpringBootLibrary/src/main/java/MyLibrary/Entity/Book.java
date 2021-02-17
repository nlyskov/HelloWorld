package MyLibrary.Entity;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Book {

    public Book(String name, Author author, Genre genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public Book(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne(targetEntity = Author.class) // много книг у одного автора
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(targetEntity = Genre.class)  // много книг одного жанра
    @JoinColumn(name = "genre_id")
    private Genre genre;
}


