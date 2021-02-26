package com.edu.web.forclass;

import com.edu.bean.Classes;
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
 * @Author: chunfeng
 * @Description: 根据查询条件 获取班级
 * @Date Created in  2020-07-07 13:17
 * @Modified By:
 */
@WebServlet(value = "/getclasses")
public class GetClassMessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1. 接收参数
        String className = req.getParameter("classname");
        req.setAttribute("name",className);
        // 接受分页参数
        int pageIndex = req.getParameter("index")==null?1:Integer.parseInt(req.getParameter("index"));
        req.setAttribute("pindex",pageIndex);  //将当前页码值返回

        // 2. 调用service方法
        ClassService service = new ClassServiceExp();
        // 总页数=总条数%每页的条数>0？总条数/每页的条数+1：总条数/每页的条数
        int total = service.totalNum(className); // 查询出的总条数
        int totalPage = total%PageSize.SIZE>0?total/PageSize.SIZE+1:total/PageSize.SIZE;  //总页数
        req.setAttribute("total",total);
        req.setAttribute("totalpage",totalPage);
        List<Classes> classesList = service.getAllclasses(className,pageIndex,PageSize.SIZE);
        req.setAttribute("clist",classesList);

        // 3. 跳转页面
        req.getRequestDispatcher("/Educational/class/list.jsp").forward(req,resp);

    }
}
