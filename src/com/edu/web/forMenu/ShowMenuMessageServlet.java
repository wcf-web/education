package com.edu.web.forMenu;

import com.edu.bean.Menu;
import com.edu.service.MenuService;
import com.edu.service.exp.MenuSerciceExp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: chunfeng
 * @Description:  菜单详情
 * @Date Created in  2020-07-12 21:40
 * @Modified By:
 */
@WebServlet(value = "/showmenumessage")
public class ShowMenuMessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int menuId = Integer.parseInt(req.getParameter("menuid"));
        // 调用service方法
        MenuService service = new MenuSerciceExp();
        Menu menu = service.getMenuById(menuId);
        req.setAttribute("menu",menu);
        // 跳页面
        req.getRequestDispatcher("/power/menu/info.jsp").forward(req,resp);
    }
}





