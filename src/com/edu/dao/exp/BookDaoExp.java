package com.edu.dao.exp;

import com.edu.bean.Book;
import com.edu.dao.BookDao;
import com.edu.util.DruidUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-08 16:38
 * @Modified By:
 */
public class BookDaoExp extends DruidUtil implements BookDao {
    @Override
    public List<Book> getBookById(int classId) {
        List<Book> bookList = new ArrayList<>();
        // 1. 定义sql语句
        String sql = "select * from book where exist=1 and classid=? ";
        // 2. 添加参数
        List params = new ArrayList();
        params.add(classId);
        // 3. 执行sql语句
        try {
            set = query(sql,params);
            while (set.next()){
                Book book = new Book();
                book.setBookNo(set.getString("bookno"));
                book.setBookName(set.getString("bookname"));
                book.setBookStatus(set.getInt("bookstatus"));
                book.setBookId(set.getInt("bookid"));
                bookList.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return bookList;
    }

    @Override
    public int changeBookStatus(int bookId,int status) {
        int flag = 0;
        // 1. 定义sql语句
        String sql = "update book " +
                "set bookstatus=? " +
                "where bookid=? ";
        // 2. 添加参数
        List params = new ArrayList();
        params.add(status);
        params.add(bookId);
        // 3. 执行sql语句
        try {
            flag = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return flag;
    }

    @Override
    public int deleteBook(int bookId) {
        int flag = 0;
        // 1.定义sql语句
        String sql="UPDATE  book\n" +
                "set exist=0\n" +
                "WHERE bookid=?";
        // 2.添加参数
        List params = new ArrayList();
        params.add(bookId);
        // 3. 执行sql语句
        try {
            flag = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return flag;
    }

    @Override
    public int addBook(int classId,String bookNo,String bookName,String content) {
        int flag = 0;
        // 1. 定义sql语句
        String sql = "insert into book(classid,bookno,bookname,content) values(?,?,?,?) ";
        // 2. 添加参数
        List params = new ArrayList();
        params.add(classId);
        params.add(bookNo);
        params.add(bookName);
        params.add(content);
        // 3.执行sql语句
        try {
            flag = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return flag;
    }


}






