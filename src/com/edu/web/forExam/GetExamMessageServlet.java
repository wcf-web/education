package com.edu.web.forExam;

import com.edu.bean.Exam;
import com.edu.service.ExamService;
import com.edu.service.exp.ExamServiceExp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-08 20:56
 * @Modified By:
 */
@WebServlet(value = "/getexammessage")
public class GetExamMessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1. 接收参数
        int examId = Integer.parseInt(req.getParameter("examid"));
        // 2.调用service方法
        ExamService service = new ExamServiceExp();
        Exam exam= service.findExamById(examId);
        req.setAttribute("exam",exam);
        // 3.  跳转页面
        req.getRequestDispatcher("/Educational/exam/view.jsp").forward(req,resp);
    }
}
