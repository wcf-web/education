package com.edu.web.forClass;

import com.edu.bean.Class;
import com.edu.service.ClassService;
import com.edu.service.exp.ClassServiceExp;
import com.edu.util.PageSize;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Desc:   班级审核
 * @Author: chunfeng
 * @Date
 */
@WebServlet(value = "/auditclass")
public class AuditClassServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1. 接收参数
        String classNo = req.getParameter("classno");
        req.setAttribute("classno",classNo);
        String className = req.getParameter("classname");
        req.setAttribute("classname",className);
        // 1.2 接收分页数据
        int index = req.getParameter("index")==null?1:Integer.parseInt(req.getParameter("index"));
        req.setAttribute("pindex",index);  //当前页码值
        // 2. 调用service方法
        ClassService service = new ClassServiceExp();
        // 总页数=总条数%每页的条数>0？总条数/每页的条数+1：总条数/每页的条数
        int total = service.totalNum(classNo,className); // 查询出的总条数
        int totalPage = total% PageSize.SIZE>0?total/PageSize.SIZE+1:total/PageSize.SIZE;  //总页数
        req.setAttribute("total",total);
        req.setAttribute("totalpage",totalPage);
        List<Class> classList = service.auditClass(classNo,className);
        req.setAttribute("clist", classList);

        // 3.跳转页面
        req.getRequestDispatcher("/Educational/Auditing.jsp").forward(req,resp);

    }
}






