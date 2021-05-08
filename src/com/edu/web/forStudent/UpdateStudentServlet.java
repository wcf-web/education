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
import java.io.PrintWriter;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-07 11:07
 * @Modified By:
 */
@WebServlet(value = "/updatestudent")
public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        req.setCharacterEncoding("utf-8");
        Student student = new Student();
        int studentId = Integer.parseInt(req.getParameter("stuid"));
        // 接收所有可能修改的属性值
        String studentNo = req.getParameter("studentNo");
        String studentName = req.getParameter("studentName");
        int collegeId = Integer.parseInt(req.getParameter("college"));
        int majorId = Integer.parseInt(req.getParameter("major"));
        int classId = Integer.parseInt(req.getParameter("class"));
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String register = req.getParameter("register");
        String address = req.getParameter("address");
        String politics = req.getParameter("politics");
        String idCard = req.getParameter("idCard");
        String content = req.getParameter("content");
        student.setStudentName(studentName); //只以修改姓名和性别为例
        student.setSex(sex);
        student.setStudentId(studentId);
        // 2. 调用service方法
        StudentService service = new StudentServiceExp();
        int num = service.updateStudent(student);
        // 3. 跳页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(num>0){
            writer.print("<script>alert('修改成功');location.href='/getstudent'</script>");
        }else {
            writer.print("<script>alert('修改失败');location.href='/findstudenttoupdate?stuid="+studentId+"'</script>");
        }
    }
}






