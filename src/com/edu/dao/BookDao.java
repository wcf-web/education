package com.edu.dao;

import com.edu.bean.Book;

import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-08 15:53
 * @Modified By:
 */
public interface BookDao {

    /**
     *根据班级id获取图书
     * @param classId
     * @return
     */
    public List<Book> getBookById(int classId);

    /**
     * 启用和禁用图书
     * @param bookId
     * @param status status为图书改变后的状态
     * @return
     */
    public int changeBookStatus(int bookId,int status);

    /**
     * 对图书进行假删除
     * @param bookId
     * @return
     */
    public int deleteBook(int bookId);

    /**
     * 给班级添加图书
     * @param classId
     * @return
     */
    public int addBook(int classId,String bookNo,String bookName,String content);
}
