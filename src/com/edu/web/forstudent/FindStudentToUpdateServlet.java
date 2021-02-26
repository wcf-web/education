package com.edu.web.forstudent;

import com.edu.bean.College;
import com.edu.bean.Student;
import com.edu.service.CollegeService;
import com.edu.service.StudentService;
import com.edu.service.exp.CollegeServiceExp;
import com.edu.service.exp.StudentServiceExp;

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
 * @Date Created in  2020-07-07 9:41
 * @Modified By:
 */
@WebServlet(value = "/findstudenttoupdate")
public class FindStudentToUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        int studentId = Integer.parseInt(req.getParameter("stuid"));
        // 2. 调用service方法
        StudentService service = new StudentServiceExp();
        Student student = service.findStudent(studentId);
        req.setAttribute("stu",student);
        // 查询学院列表
        CollegeService collegeservice = new CollegeServiceExp();
        List<College> collegeList = collegeservice.getAllCollege();
        req.setAttribute("collegeList",collegeList);
        // 3. 跳转页面
        req.getRequestDispatcher("/Educational/student/update.jsp").forward(req,resp);
    }
}
