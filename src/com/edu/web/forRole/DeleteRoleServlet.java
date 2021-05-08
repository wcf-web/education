package com.edu.web.forRole;

import com.edu.service.RoleService;
import com.edu.service.exp.RoleServiceExp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-10 15:26
 * @Modified By:
 */
@WebServlet(value = "/deleterole")
public class DeleteRoleServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        int roleId = Integer.parseInt(req.getParameter("roleid"));
        // 2. 调用service方法
        RoleService service = new RoleServiceExp();
        boolean flag = service.deleteRole(roleId);
        // 3.跳页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(flag==true){
            writer.print("<script>alert('删除成功');location.href='/getrole'</script>");
        }else {
            writer.print("<script>alert('删除失败');location.href='/getrole'</script>");
        }
    }
}
