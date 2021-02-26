package com.edu.web.foruser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: chunfeng
 * @Description:  用户退出
 * @Date Created in  2020-07-10 17:21
 * @Modified By:
 */
@WebServlet(value = "/userexit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 清除当前用户
        req.removeAttribute("thisuser");
        // 跳页面
        req.getRequestDispatcher("/login.html").forward(req,resp);
    }
}
