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
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-09 13:29
 * @Modified By:
 */
@WebServlet(value = "/getuser")
public class GetUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收参数
        // 2.调用service 方法
        UserService service = new UserServiceExp();
        List<User> list = service.getAllUser();
        req.setAttribute("ulist",list);
        // 3. 跳转页面
        req.getRequestDispatcher("/power/user/list.jsp").forward(req,resp);
    }
}
