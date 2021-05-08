package com.edu.web.forStudent;

import com.edu.bean.Student;
import com.edu.service.StudentService;
import com.edu.service.exp.StudentServiceExp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-07 17:21
 * @Modified By:
 */
@WebServlet(value = "/showstudentmesssge")
public class ShowStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        int studentId = Integer.parseInt(req.getParameter("stuid"));
        // 2. 调用service方法
        StudentService service = new StudentServiceExp();
        Student student = service.findStudent(studentId);
        req.setAttribute("stu",student);
        // 3. 跳转页面
        req.getRequestDispatcher("/Educational/student/view.jsp").forward(req,resp);

    }
}
