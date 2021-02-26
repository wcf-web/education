package com.edu.web.forclass;

import com.edu.bean.Classes;
import com.edu.service.ClassService;
import com.edu.service.exp.ClassServiceExp;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author: chunfeng
 * @Description: 根据学院和专业 查找班级
 * @Date Created in  2020-07-08 10:59
 * @Modified By:
 */
@WebServlet(value = "/getclass")
public class GetClassesServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        int collegeId = Integer.parseInt(req.getParameter("collegeid"));
        int majorId = Integer.parseInt(req.getParameter("majorid"));

        // 2. 调用service 方法
        ClassService service = new ClassServiceExp();
        List<Classes> classesList = service.getClassById(collegeId,majorId);
        JSONArray object = JSONArray.fromObject(classesList);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(object);
    }
}











