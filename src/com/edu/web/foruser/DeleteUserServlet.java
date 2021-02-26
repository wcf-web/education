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
 * @Description:  删除用户，用户只能删除比自己权限低的用户
 * @Date Created in  2020-07-09 17:10
 * @Modified By:
 */
@WebServlet(value = "/deleteuser")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取参数
        int userId = Integer.parseInt(req.getParameter("userid"));  //被删除者的userid
        int userRole = Integer.parseInt(req.getParameter("role"));      //被删除者的role
        // 获取当前用户
        User thisUser = (User)req.getSession().getAttribute("thisuser");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(userRole <= thisUser.getRole()){
            writer.print("<script>alert('您没有权限');location.href='/getuser'</script>");
            return;
        }
        // 2. 若有权限，则调用service方法
        UserService service = new UserServiceExp();
        int flag = service.deleteUser(userId);
        if(flag>0){
            writer.print("<script>alert('删除成功');location.href='/getuser'</script>");
        }else {
            writer.print("<script>alert('删除失败');location.href='/getuser'</script>");
        }
    }
}
