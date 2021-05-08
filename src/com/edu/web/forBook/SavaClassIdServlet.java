package com.edu.web.forBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-09 9:51
 * @Modified By:
 */
@WebServlet(value = "/saveid")
public class SavaClassIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        int classId = Integer.parseInt(req.getParameter("classid"));
        req.setAttribute("classid",classId);
        // 2. 跳转页面
        req.getRequestDispatcher("/Educational/book/add.jsp").forward(req,resp);
    }
}
