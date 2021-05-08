package com.edu.web.forClass;

import com.edu.bean.Class;
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
 * @Desc:   寻找班级，并跳转到班级页
 * @Date
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
        Class aClass = service.findClass(classId);
        req.setAttribute("classes", aClass);
        // 3. 跳转页面
        req.getRequestDispatcher("/Educational/class/info.jsp").forward(req,resp);
    }
}
