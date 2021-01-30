package MyLibrary.Model;

import org.springframework.data.relational.core.sql.In;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private String genre;

    public Book(Integer id, String name, String author, String genre) {
        this.id = id;
        this.name = name;
        this.author = author;

        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}


