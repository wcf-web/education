package com.edu.web.forRole;

import com.edu.bean.Menu;
import com.edu.bean.Role;
import com.edu.service.MenuService;
import com.edu.service.RoleService;
import com.edu.service.exp.MenuSerciceExp;
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
 * @Description:  角色的详情
 * @Date Created in  2020-07-12 20:02
 * @Modified By:
 */
@WebServlet(value = "/showrolemessage")
public class ShowRoleMessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收参数
        int roleId = Integer.parseInt(req.getParameter("roleid"));
        // 2.调用service方法
        RoleService service = new RoleServiceExp();
        Role role = service.showRoleMessage(roleId); //获取角色信息
        req.setAttribute("role",role);
        List<Menu> menuList = service.getRoleMenu(roleId);  //获取角色对应的菜单
        req.setAttribute("mlist",menuList);
        for ( Menu m:
                menuList ) {
            System.out.println(m);
        }
        // 获取全部的顶级菜单和次级菜单
        MenuService service1 = new MenuSerciceExp();
        List<Menu> menuList1 = service1.getAllMenu();
        req.setAttribute("allmenu",menuList1);
        // 3.跳页面
        req.getRequestDispatcher("/power/role/info.jsp").forward(req,resp);
    }
}
