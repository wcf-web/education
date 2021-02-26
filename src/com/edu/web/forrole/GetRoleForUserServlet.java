package com.edu.web.forrole;

import com.edu.bean.Role;
import com.edu.service.RoleService;
import com.edu.service.exp.RoleServiceExp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:  在进入用户新增页面时 获取全部角色信息，供页面使用
 * @Date Created in  2020-07-10 14:07
 * @Modified By:
 */
@WebServlet(value = "/getallrole")
public class GetRoleForUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收参数
        // 2.调用service方法
        RoleService servlice = new RoleServiceExp();
        List<Role> roleList = servlice.getAllRole();
        req.setAttribute("rlist",roleList);
        // 3.跳转页面
        req.getRequestDispatcher("/power/user/add.jsp").forward(req,resp);
    }
}





