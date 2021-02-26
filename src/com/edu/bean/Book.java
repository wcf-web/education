package com.edu.bean;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-08 15:47
 * @Modified By:
 */
public class Book {
    private int bookId;
    private String bookNo;
    private String bookName;
    private int bookStatus;  //  1:启用  0：禁用
    private String content;
    private int bookExist; // 1:未删除  0：已删除

    public int getBookExist() {
        return bookExist;
    }

    public void setBookExist(int bookExist) {
        this.bookExist = bookExist;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(int bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
