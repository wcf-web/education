package com.edu.web.forExam;

import com.edu.bean.Exam;
import com.edu.service.ExamService;
import com.edu.service.exp.ExamServiceExp;
import com.edu.util.PageSize;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Desc:   获取所有班级
 * @Author: chunfeng
 * @Date
 */
@WebServlet(value = "/getexam")
public class GetExamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1.接收参数
        String examName = req.getParameter("examname");
        req.setAttribute("examname",examName);
        // 接受分页数据
        int pageIndex = req.getParameter("index")==null?1:Integer.parseInt(req.getParameter("index"));
        req.setAttribute("pindex",pageIndex);   // 当前页数
        // 2. 调用service方法
        ExamService service = new ExamServiceExp();
        int total = service.totalNum(examName); //总条数
        int totalPage = total%PageSize.SIZE>0?total/PageSize.SIZE+1:total/PageSize.SIZE; //总页数
        req.setAttribute("total",total);
        req.setAttribute("totalpage",totalPage);

        List<Exam> examList = service.getAllExam(examName,pageIndex,PageSize.SIZE);
        req.setAttribute("elist",examList);
        // 3. 跳转页面
        req.getRequestDispatcher("/Educational/exam/exam.jsp").forward(req,resp);
    }
}
