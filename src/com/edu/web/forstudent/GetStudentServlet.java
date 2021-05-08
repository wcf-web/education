package com.edu.web.forstudent;

import com.edu.bean.Student;
import com.edu.service.StudentService;
import com.edu.service.exp.StudentServiceExp;
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
 * @Description:
 * @Date Created in  2020-07-05 17:58
 * @Modified By:
 */
@WebServlet(value = "/getstudent")
public class GetStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 模糊查
        req.setCharacterEncoding("utf-8");
        // 1.1 接收模糊查询的参数
        String studentName = req.getParameter("studentName");
        String studentNo = req.getParameter("studentNo");
        int studentSex = req.getParameter("studentSex")==null?-1:Integer.parseInt(req.getParameter("studentSex"));
        req.setAttribute("name",studentName);
        req.setAttribute("number",studentNo);
        // 1.2 接收分页数据
        int index = req.getParameter("index")==null?1:Integer.parseInt(req.getParameter("index"));
        req.setAttribute("pindex",index);  //当前页码值

        // 2.调取service方法
        StudentService service = new StudentServiceExp();
        // 总页数=总条数%每页的条数>0？总条数/每页的条数+1：总条数/每页的条数
        int total = service.totalNum(studentName,studentNo,studentSex); // 查询出的总条数
        int totalPage = total%PageSize.SIZE>0?total/PageSize.SIZE+1:total/PageSize.SIZE;  //总页数
        req.setAttribute("total",total);
        req.setAttribute("totalpage",totalPage);

        List<Student> all = service.searchAllStudent(studentName,studentNo,studentSex,index, PageSize.SIZE);
        for (Student i:
        all     ) {
            System.out.println(i);
        }
        req.getSession().setAttribute("stulist",all);
        // 3.跳转页面
        req.getRequestDispatcher("/Educational/student/list.jsp").forward(req,resp);
    }
}
