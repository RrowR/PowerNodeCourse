package day27;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String isbn;
    private String bookName;
    private String author;
    private double price;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishTime;
}
