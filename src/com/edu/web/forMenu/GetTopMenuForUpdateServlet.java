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
 * @Date Created in  2020-07-10 11:10
 * @Modified By:
 */
@WebServlet(value = "/gettopmenu2")
public class GetTopMenuForUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收参数
        // 2.调用service方法
        MenuService service = new MenuSerciceExp();
        List<Menu> menuList = service.getTopMenu();
        req.setAttribute("mlist",menuList);
        // 3.跳页面
        req.getRequestDispatcher("/power/menu/edit.jsp").forward(req,resp);
    }
}
