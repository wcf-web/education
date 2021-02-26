package com.edu.service.exp;

import com.edu.bean.Book;
import com.edu.dao.BookDao;
import com.edu.dao.exp.BookDaoExp;
import com.edu.service.BookService;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-08 16:57
 * @Modified By:
 */
public class BookServiceExp implements BookService {
    private BookDao dao = new BookDaoExp();
    @Override
    public List<Book> getBookById(int classId) {
        return dao.getBookById(classId);
    }

    @Override
    public int changeBookStatus(int bookId, int status) {
        return dao.changeBookStatus(bookId,status);
    }

    @Override
    public int deleteBook(int bookId) {
        return dao.deleteBook(bookId);
    }

    @Override
    public int addBook(int classId, String bookNo, String bookName,String content) {
        return dao.addBook(classId,bookNo,bookName,content);
    }
}
