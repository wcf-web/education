package com.edu.web.forExam;

import com.edu.service.ExamService;
import com.edu.service.exp.ExamServiceExp;

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
 * @Description: 添加考试
 * @Date Created in  2020-07-08 9:42
 * @Modified By:
 */
@WebServlet(value = "/addexam")
public class AddExamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        req.setCharacterEncoding("utf-8");
        String examNo = req.getParameter("examno");
        String examSubject = req.getParameter("examsubject");
        Date examTime = java.sql.Date.valueOf(req.getParameter("examtime"));
        int classId = Integer.parseInt(req.getParameter("class"));
        int examCount = Integer.parseInt(req.getParameter("examcount"));
        // 判断考试状态  1:未考 2：考试中 2：已考完
        int examState = 1;
        String status = req.getParameter("examstate");
        if(status.equals("未考")){
            examState = 1;
        }else if(status.equals("考试中")){
            examState = 2;
        }else if(status.equals("已考完")){
            examState = 3;
        }

        // 2. 调用service方法
        ExamService service = new ExamServiceExp();
        int flag = service.addExam(examNo,examSubject,examTime,classId,examCount,examState);
        // 3.跳转页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(flag>0){
            writer.print("<script>alert('添加成功');location.href='/getexam'</script>");
        }else {
            writer.print("<script>alert('添加失败');location.href='/getcollegeforexam.do'</script>");
        }
    }
}











