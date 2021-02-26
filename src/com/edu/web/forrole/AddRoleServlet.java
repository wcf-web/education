package com.edu.web.forrole;

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
 * @Date Created in  2020-07-13 9:25
 * @Modified By:
 */
@WebServlet(value = "/addrole")
public class AddRoleServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1.接收参数
        String roleName = req.getParameter("rolename");
        String[] menus = req.getParameterValues("menu");
        int[] menuIds = new int[menus.length];
        for (int i=0;i<menus.length;i++){
            menuIds[i]= Integer.parseInt(menus[i]);
        }
        int roletatus = Integer.parseInt(req.getParameter("state"));
        // 调用service方法
        RoleService service = new RoleServiceExp();
        int flag = service.addRole(roleName,roletatus,menuIds);
        // 3. 跳页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(flag > 0){
            writer.print("<script>alert('添加成功');location.href='/getrole'</script>");
        }else {
            writer.print("<script>alert('添加失败');location.href='/addrole'</script>");
        }
    }
}







