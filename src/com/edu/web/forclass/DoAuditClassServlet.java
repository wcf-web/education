package com.edu.web.forclass;

import com.edu.service.ClassService;
import com.edu.service.exp.ClassServiceExp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: chunfeng
 * @Description:
 * @Date Created in  2020-07-08 14:58
 * @Modified By:
 */
@WebServlet(value = {"/pass.do","/reject.do"})
public class DoAuditClassServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 截取url
        String url = req.getRequestURI();
        String path = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
        // 1. 接收参数
        int classId = Integer.parseInt(req.getParameter("classid"));
        // 2. 调用service方法
        ClassService service = new ClassServiceExp();
        // 3. 跳转页面
        int flag = 0;
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        // 根据请求的url来判断 通过还是驳回
        if(path.equals("pass")){
            flag = service.passClassStatus(classId);
            if(flag>0) {
                writer.print("<script>alert('操作成功');location.href='/auditclass'</script>");
            }else {
                writer.print("<script>alert('操作失败');location.href='/auditclass'</script>");
            }
        }else {
            flag = service.rejectClassStatus(classId);
            if(flag>0) {
                writer.print("<script>alert('操作成功');location.href='/auditclass'</script>");
            }else {
                writer.print("<script>alert('操作失败');location.href='/auditclass'</script>");
            }
        }

    }
}
