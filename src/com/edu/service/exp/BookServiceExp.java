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
        return dao.changeBookStatus(bookId, status);
    }

    @Override
    public int deleteBook(int bookId) {
        return dao.deleteBook(bookId);
    }

    /**
     * 新增书籍时，bookstatus和exist默认为1
     * @param classId
     * @param bookNo
     * @param bookName
     * @param content
     * @return
     */
    @Override
    public int addBook(int classId, String bookNo, String bookName,String content) {
        return dao.addBook(classId, bookNo, bookName, content);
    }
}
