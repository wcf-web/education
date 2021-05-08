package com.edu.web.forbook;

import com.edu.bean.Book;
import com.edu.service.BookService;
import com.edu.service.exp.BookServiceExp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description: 根据班级id 获取相应书籍
 * @Date Created in  2020-07-08 16:59
 * @Modified By:
 */
@WebServlet(value = "/getbook")
public class GetBookServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        int classId = Integer.parseInt(req.getParameter("classid"));
        req.setAttribute("classid",classId);
        // 2. 调用service方法
        BookService service = new BookServiceExp();
        List<Book> bookList = service.getBookById(classId);
        req.setAttribute("blist",bookList);
        // 3. 跳转页面
        req.getRequestDispatcher("/Educational/book/list.jsp").forward(req,resp);
    }
}
