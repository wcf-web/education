package com.edu.web.forMenu;

import com.edu.bean.User;
import com.edu.service.MenuService;
import com.edu.service.exp.MenuSerciceExp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description: 为不同的的角色展现不同的菜单页面
 * @Date Created in  2020-07-10 16:28
 * @Modified By:
 */
@WebServlet(value = "/selectmenu")
public class SelectMenuForRoleServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数,获取当前用户的角色id
        User user = (User) req.getSession().getAttribute("thisuser");
        int roleId = user.getRole();
        // 2.调用service方法
        MenuService service = new MenuSerciceExp();
        // 通过不同的角色id，得到相应的菜单选项
        List<Integer> menuList = service.selectMenu(roleId);
        req.getSession().setAttribute("mlist",menuList);
        // 3.跳页面
        req.getRequestDispatcher("/index.html").forward(req,resp);
    }
}








