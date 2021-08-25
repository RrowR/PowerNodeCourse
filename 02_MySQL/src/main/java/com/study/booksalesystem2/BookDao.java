package com.study.booksalesystem2;

import com.study.booksalesystem2.entity.Book;

import java.util.List;

/**
 *  这里定义接口的时候需要有一个总揽全局的思路，因为接口定义意味着实现类会根据接口的返回值类型，参数类型来实现
 */
public interface BookDao {
    int addBook(Book book);
    int deleteBook(Integer id);
    int updateBook(Book book);
    List<Book> queryAllBooks();
    Book queryBookById(Integer id);
}
