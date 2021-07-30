package day28;

import java.util.Date;

public class Book {
    private String isbn;
    public String author;

    @myDateFormate("yyyy/MM/dd")
    private Date date;

    public Book() {
    }

    public Book(String isbn, String author, Date date) {
        this.isbn = isbn;
        this.author = author;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }

}
