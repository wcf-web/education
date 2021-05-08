package com.edu.web.forUser;

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
 * @Description:
 * @Date Created in  2020-07-09 15:15
 * @Modified By:
 */
@WebServlet(value = "/adduser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1.接收参数
        String acount = req.getParameter("account");
        String password = req.getParameter("password");
        String userName = req.getParameter("username");
        String sex = req.getParameter("sex");
        String roleId = req.getParameter("roleid");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String idCard = req.getParameter("idCard");
        String content = req.getParameter("content");
        // 2. 调用service方法
        UserService service = new UserServiceExp();
        int flag = service.addUser(acount,password,userName,sex,roleId,email,phone,address,idCard,content);
        // 3.跳页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(flag>0){
            writer.print("<script>alert('添加成功');location.href='/getuser'</script>");
        }else {
            writer.print("<script>alert('添加失败');location.href='/getuser'</script>");
        }
    }
}
