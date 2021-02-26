package com.edu.web;

import com.edu.bean.College;
import com.edu.dao.CollegeDao;
import com.edu.service.CollegeService;
import com.edu.service.exp.CollegeServiceExp;

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
 * @Date Created in  2020-07-06 18:32
 * @Modified By:
 */
@WebServlet(value = {"/getcollegeforstudent.do","/getcollegeforclass.do","/getcollegeforexam.do"})
public class GetcollegeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        // 2. 调用service方法
        CollegeService service = new CollegeServiceExp();
        List<College> collegeList = service.getAllCollege();
        req.setAttribute("collegeList",collegeList);
        // 3. 跳转页面
        // 根据路径跳转页面
        String url = req.getRequestURI();
        String path = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));

        if(path.equals("getcollegeforstudent")){
            req.getRequestDispatcher("/Educational/student/add.jsp").forward(req,resp);
        }else if(path.equals("getcollegeforclass")){
            req.getRequestDispatcher("/Educational/class/add.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/Educational/exam/add.jsp").forward(req,resp);
        }
    }
}
