package com.edu.web.forstudent;

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
 * @Date Created in  2020-07-07 7:48
 * @Modified By:
 */
@WebServlet(value = "/addstudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取参数
        req.setCharacterEncoding("utf-8");
        String studentNo = req.getParameter("studentNo");
        String studentName = req.getParameter("studentName");
        int collegeId = Integer.parseInt(req.getParameter("college"));
        int majorId = Integer.parseInt(req.getParameter("majorid"));
        int classId = Integer.parseInt(req.getParameter("class"));
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String register = req.getParameter("register");
        String address = req.getParameter("address");
        String politics = req.getParameter("politics");
        String idCard = req.getParameter("idCard");
        String content = req.getParameter("content");
        Student student = new Student(studentNo,studentName,collegeId,majorId,classId,sex,email,phone,register,address,politics,idCard,content);
        // 2. 调取方法
        StudentService service = new StudentServiceExp();
        int num = service.insertStudent(student);
        // 3. 跳转页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(num>0){
            writer.print("<script>alert('添加成功');location.href='/getstudent'</script>");
        }else {
            writer.print("<script>alert('添加失败');location.href='/getcollegeforstudent.do'</script>");
        }
    }
}








