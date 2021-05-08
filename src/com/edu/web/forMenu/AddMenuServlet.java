package com.edu.web.forMenu;

import com.edu.service.MenuService;
import com.edu.service.exp.MenuSerciceExp;

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
 * @Date Created in  2020-07-10 10:42
 * @Modified By:
 */
@WebServlet(value = "/addmenu")
public class AddMenuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1. 接收参数
        String menuName = req.getParameter("menuname");
        int parentId = Integer.parseInt(req.getParameter("parentid"));
        String utl = req.getParameter("utl");
        String menustatus = req.getParameter("state");
        String content = req.getParameter("content");
        // 2. 调用service方法
        MenuService service = new MenuSerciceExp();
        int flag = service.addMenu(menuName,parentId,utl,menustatus,content);
        // 3. 跳页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(flag > 0){
            writer.print("<script>alert('添加成功');location.href='/getmenu'</script>");
        }else {
            writer.print("<script>alert('添加失败');location.href='/getmenu'</script>");
        }
    }
}
