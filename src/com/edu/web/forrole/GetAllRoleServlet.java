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
 * @Description:  获取全部的角色信息
 * @Date Created in  2020-07-09 21:19
 * @Modified By:
 */
@WebServlet(value = "/getrole")
public class GetAllRoleServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        // 2. 调用service
        RoleService servlice = new RoleServiceExp();
        List<Role> roleList = servlice.getAllRole();
        req.setAttribute("rlist",roleList);
        // 3. 跳页面
        req.getRequestDispatcher("/power/role/list.jsp").forward(req,resp);
    }
}
