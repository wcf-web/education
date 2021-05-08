package com.edu.web.foruser;

import com.edu.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: chunfeng
 * @Description:  用户修改，只判断用户有没有修改的权限，并不做真正的修改
 *                用户只能修改自己或比自己权限低的用户
 * @Date Created in  2020-07-09 16:39
 * @Modified By:
 */
@WebServlet(value = "/updateuser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收参数
        int userRole = Integer.parseInt(req.getParameter("userrole"));
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        // 获取当前用户
        User thisUser = (User)req.getSession().getAttribute("thisuser");
        if(userRole < thisUser.getRole()){
            writer.print("<script>alert('您没有权限');location.href='/getuser'</script>");
            return;
        }
        req.getRequestDispatcher("/power/user/edit.jsp").forward(req,resp);
    }
}
