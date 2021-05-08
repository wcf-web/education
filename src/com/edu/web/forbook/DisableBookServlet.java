package com.edu.web.forbook;

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
 * @Description:  禁用书籍
 * @Date Created in  2020-07-08 23:24
 * @Modified By:
 */
@WebServlet(value = "/disable.do")
public class DisableBookServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收参数
        int bookId = Integer.parseInt(req.getParameter("bookid"));
        req.setAttribute("bookid",bookId);
        int classId = Integer.parseInt(req.getParameter("classid"));
        // 2.调用service方法
        BookService service = new BookServiceExp();
        int flag = service.changeBookStatus(bookId,0);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(flag>0){
            writer.print("<script>alert('禁用成功');location.href='/getbook?classid="+classId+"'</script>");
        }else {
            writer.print("<script>alert('禁用失败');location.href='/getbook?classid="+classId+"'</script>");
        }
    }
}

