package com.edu.web.forMenu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: chunfeng
 * @Description:  更改menu的信息
 * @Date Created in  2020-07-12 22:33
 * @Modified By:
 */
@WebServlet(value = "/updatemenu")
public class UpdateMenuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int menuId = Integer.parseInt(req.getParameter("menuid"));
        //
    }
}
