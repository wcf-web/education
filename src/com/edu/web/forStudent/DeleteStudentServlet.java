package com.edu.web.forStudent;

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
 * @Date Created in  2020-07-07 11:43
 * @Modified By:
 */
@WebServlet(value = "/deletestudent")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        int stuid = Integer.parseInt(req.getParameter("stuid"));
        // 2，调用service方法
        StudentService service = new StudentServiceExp();
        int num = service.deleteStudent(stuid);
        // 3. 跳页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(num>0){
            writer.print("<script>alert('删除成功');location.href='/getstudent'</script>");
        }else {
            writer.print("<script>alert('删除失败');location.href='/getstudent''</script>");
        }
    }
}
