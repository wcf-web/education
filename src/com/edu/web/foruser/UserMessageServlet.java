package com.edu.web.foruser;

import com.edu.bean.User;
import com.edu.service.UserService;
import com.edu.service.exp.UserServiceExp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-09 14:09
 * @Modified By:
 */
@WebServlet(value = "/getmessage")
public class UserMessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        int userId = Integer.parseInt(req.getParameter("userid"));
        // 2. 调用service方法
        UserService service = new UserServiceExp();
        User user = service.getUserById(userId);
        req.setAttribute("user",user);
        // 3. 跳页面
        req.getRequestDispatcher("/power/user/info.jsp").forward(req,resp);
    }
}







