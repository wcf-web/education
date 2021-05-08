package com.edu.web.forMajor;

import com.alibaba.fastjson.JSON;
import com.edu.bean.Major;
import com.edu.service.MajorService;
import com.edu.service.exp.MajorServiceExp;
import net.sf.json.JSONArray;

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
 * @Description: 根据学院的id，找到该学院的所有专业
 * @Date Created in  2020-07-06 20:17
 * @Modified By:
 */
@WebServlet(value = "/getmajor")
public class GetMajorServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        int collegeId = Integer.parseInt(req.getParameter("collegeid"));
        // 2. 调用service方法
        // 根据所查学院，找到相应的专业
        MajorService service = new MajorServiceExp();
        List<Major> majorList = service.getAllMajor(collegeId);
        // 3.跳转页面，ajax默认返回原页面
        //JSONArray object = JSONArray.fromObject(majorList);
        String object = JSON.toJSONString(majorList);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(object);

    }
}
