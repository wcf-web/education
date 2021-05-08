package com.edu.web.forBook;

import com.edu.service.BookService;
import com.edu.service.exp.BookServiceExp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: chunfeng
 * @Description: 根据班级 对其添加新书
 * @Date Created in  2020-07-09 8:16
 * @Modified By:
 */
@WebServlet(value = "/addbook")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        req.setCharacterEncoding("utf-8");
        int classId = Integer.parseInt(req.getParameter("classid"));
        String bookNo = req.getParameter("bookno");
        String bookName = req.getParameter("bookname");
        String content = req.getParameter("content");
        // 2. 调用service方法
        BookService service = new BookServiceExp();
        int flag = service.addBook(classId,bookNo,bookName,content);
        // 3. 跳页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(flag>0){
            writer.print("<script>alert('添加成功');location.href='/getbook?classid="+classId+"'</script>");
        }else {
            writer.print("<script>alert('添加失败');location.href='/getbook?classid="+classId+"'</script>");
        }
    }
}
