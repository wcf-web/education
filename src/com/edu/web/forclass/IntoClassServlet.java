package com.edu.web.forclass;

import com.edu.bean.Classes;
import com.edu.service.ClassService;
import com.edu.service.exp.ClassServiceExp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-07 21:21
 * @Modified By:
 */
@WebServlet(value = "/intoclass")
public class IntoClassServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取参数
        req.setCharacterEncoding("utf-8");
        int classId = Integer.parseInt(req.getParameter("classid"));
        // 2. 调用service方法
        ClassService service = new ClassServiceExp();
        Classes classes = service.findClass(classId);
        req.setAttribute("classes",classes);
        // 3. 跳转页面
        req.getRequestDispatcher("/Educational/class/info.jsp").forward(req,resp);
    }
}
