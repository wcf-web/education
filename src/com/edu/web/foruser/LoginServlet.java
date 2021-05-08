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
import java.io.PrintWriter;

/**
 * @Author: chunfeng
 * @Description:  用户登录
 * @Date Created in  2020-07-09 10:30
 * @Modified By:
 */
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        // 2. 调用service 方法
        UserService service = new UserServiceExp();
        boolean flag = service.userLogin(account,password);
        User user = service.findUserByAccount(account);
        req.getSession().setAttribute("thisuser",user);
        // 3. 跳转页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(flag==true){
            writer.print("<script>alert('登陆成功');location.href='/selectmenu'</script>");
        }else {
            writer.print("<script>alert('登录失败');location.href='/login.html'</script>");
        }
    }
}
