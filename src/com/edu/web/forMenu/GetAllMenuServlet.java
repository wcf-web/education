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
import java.util.List;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-10 8:40
 * @Modified By:
 */
@WebServlet(value = "/getmenu")
public class GetAllMenuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        // 2. 调用service方法
        MenuService service = new MenuSerciceExp();
        List<Menu> menus = service.getAllMenu();
        req.setAttribute("mlist",menus);
        // 3. 跳页面
        req.getRequestDispatcher("/power/menu/list.jsp").forward(req,resp);
    }
}







