package com.edu.web.forClass;

import com.edu.service.ClassService;
import com.edu.service.exp.ClassServiceExp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-07 18:09
 * @Modified By:
 */
@WebServlet(value = "/addclass")
public class AddClassServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        req.setCharacterEncoding("utf-8");
        String classNo = req.getParameter("classno");
        System.out.println(classNo);
        int collegeId = Integer.parseInt(req.getParameter("collegeid"));
        int majorId = Integer.parseInt(req.getParameter("majorid"));
        String className = req.getParameter("classname");
        Date startDate = java.sql.Date.valueOf(req.getParameter("startdate"));
        Date endDate = java.sql.Date.valueOf(req.getParameter("enddate"));
        int classNum = Integer.parseInt(req.getParameter("classnum"));
        int teacherId = Integer.parseInt(req.getParameter("teacherid"));
        String content = req.getParameter("content");

        // 2. 调用service方法
        ClassService service = new ClassServiceExp();
        int num = service.addClass(classNo,collegeId,majorId,className,startDate,endDate,classNum,teacherId,content);

        // 3. 跳转页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(num>0){
            writer.print("<script>alert('添加成功');location.href='/getclasses'</script>");
        }else {
            writer.print("<script>alert('添加失败');location.href='/getcollegeforclass.do'</script>");
        }
    }
}










