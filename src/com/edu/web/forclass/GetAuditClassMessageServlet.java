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
 * @Description: 获取待审核班级的信息
 * @Date Created in  2020-07-08 20:31
 * @Modified By:
 */
@WebServlet(value = "/showauditclass")
public class GetAuditClassMessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取信息
        int classId = Integer.parseInt(req.getParameter("classid"));
        req.setAttribute("classid",classId);
        // 2. 调用service方法
        ClassService service = new ClassServiceExp();
        Classes classes = service.findClass(classId);
        req.setAttribute("classes",classes);
        // 3. 跳转页面
        req.getRequestDispatcher("/Educational/class/view.jsp").forward(req,resp);
    }
}




