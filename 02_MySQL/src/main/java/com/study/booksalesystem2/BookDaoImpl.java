package com.study.booksalesystem2;

import com.study.booksalesystem2.entity.Book;
import com.study.demo10.dao.BaseDao;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into Book(bookId, bookName, author, publishTime, price, num) value(?,?,?,?,?,?)";
        Object[] params = {book.getBookId(),book.getBookName(),book.getAuthor(),book.getPublishTime(),book.getNum()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int deleteBook(Integer id) {
        return 0;
    }

    @Override
    public int updateBook(Book book) {
        return 0;
    }

    @Override
    public List<Book> queryAllBooks() {
        return null;
    }

    @Override
    public Book queryBookById(Integer id) {
        return null;
    }
}
