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
 * @Date Created in  2020-07-09 21:32
 * @Modified By:
 */
@WebServlet(value = {"/enablerole.do","/disablerole.do"})
public class AbleRoleServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int flag = 0;
        // 1. 接收参数
        int roleId = Integer.parseInt(req.getParameter("roleid"));
        String url = req.getRequestURI();
        String path = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
        // 2. 调用service方法
        RoleService servlice = new RoleServiceExp();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(path.equals("enablerole")){
            flag = servlice.EnableRole(roleId);
            if(flag>0){
                writer.print("<script>alert('启用成功');location.href='/getrole'</script>");
            }else {
                writer.print("<script>alert('启用失败');location.href='/getrole'</script>");
            }
        }else {
            flag = servlice.DisableRole(roleId);
            if(flag>0){
                writer.print("<script>alert('禁用成功');location.href='/getrole'</script>");
            }else {
                writer.print("<script>alert('禁用失败');location.href='/getrole'</script>");
            }
        }

    }
}




