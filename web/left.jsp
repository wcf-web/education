<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv=content-type content="text/html; charset=utf-8" />
        <link href="css/admin.css" type="text/css" rel="stylesheet" />
        <script language=javascript>
            function expand(el)
            {
                childobj = document.getElementById("child" + el);

                if (childobj.style.display == 'none')
                {
                    childobj.style.display = 'block';
                }
                else
                {
                    childobj.style.display = 'none';
                }
                return;
            }
        </script>
    </head>
    <body background=img/menu_bg.jpg >
        <table height="100%" cellspacing=0 cellpadding=0 width=170   background=./img/menu_bg.jpg border=0>
            <tr>
                <td valign=top align=middle>
                    <table cellspacing=0 cellpadding=0 width="100%" border=0>
						<tr>
                            <td height=10></td>
						</tr>
					</table>
					<c:forEach items="${mlist}" var="list">
						<c:if test="${list==1}">
							<table cellspacing=0 cellpadding=0 width=150 border=0>
								<tr height=22>
									<td style="padding-left: 30px" background=./img/menu_bt.jpg>
									   <a     class=menuparent onclick=expand(1)  href="javascript:void(0);">个人中心</a>
									 </td>
								</tr>
								<tr height=4>
									<td></td>
								</tr>
							</table>
						</c:if>
                    		<table id=child1 style="display: none" cellspacing=0 cellpadding=0  width=150 border=0>
                        
						<tr height=20>
                            <td align=middle width=30>
								<img height=9 src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild  href="user/MyUser.html"  target="right">我的资料</a>
							</td>
						</tr>
                        <tr height=20>
                            <td align=middle width=30>
								<img height=9   src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild  href="user/class.html"  target="right">班级信息</a>
							</td>
						</tr>
						<tr height=20>
                            <td align=middle width=30>
								<img height=9   src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild  href="user/password.html"  target="right">修改密码</a>
							</td>
						</tr>
						<!--<tr height=20>
                            <td align=middle width=30>
								<img height=9   src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild  href="user/systemMsge.html"  target="right">学院通知</a>
							</td>
						</tr>-->
                       
                        <tr height=4>
                            <td colspan=2></td>
						</tr>
					</table>
						<c:if test="${list==2}">
							<table cellspacing=0 cellpadding=0 width=150 border=0>
                        <tr height=22>
                            <td style="padding-left: 30px" background=./img/menu_bt.jpg>
							   <a     class=menuparent onclick=expand(2)    href="javascript:void(0);">教务中心</a>
							 </td>
						</tr>
                        <tr height=4>
                            <td></td>
						</tr>
					</table>
						</c:if>
							<table id=child2 style="display: none" cellspacing=0 cellpadding=0  width=150 border=0>
                        
						<tr height=20>
                            <td align=middle width=30>
								<img height=9  src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild  href="/getclasses"   target="right">班级管理</a>
							</td>
						</tr>
						
						<tr height=20>
                            <td align=middle width=30>
								<img height=9  src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<!--Educational.student.list.jsp-->
								<a class=menuchild  href="/getstudent" target="right">学生管理</a>
							</td>
						</tr>
						
						
                        <tr height=20>
                            <td align=middle width=30>
								<img height=9 src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild href="/getexam" target="right">组织考试</a>
							</td>
						</tr>

						 <tr height=20>
                            <td align=middle width=30>
								<img height=9 src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild  href="/auditclass"  target="right">班级审核</a>
							</td>
						</tr>
						
                        <tr height=4>
                            <td colspan=2></td>
						</tr>
					</table>
						<c:if test="${list==3}">
							<table cellspacing=0 cellpadding=0 width=150 border=0>
                        <tr height=22>
                            <td style="padding-left: 30px" background=./img/menu_bt.jpg>
								<%--将学员改为学生--%>
							   <a     class=menuparent onclick=expand(3)    href="javascript:void(0);">学生中心</a>
							 </td>
						</tr>
                        <tr height=4>
                            <td></td>
						</tr>
					</table>
						</c:if>
							<table id=child3 style="display: none" cellspacing=0 cellpadding=0  width=150 border=0>
                        
						<tr height=20>
                            <td align=middle width=30>
								<img height=9 src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild  href="user/msg.html"  target="right">学员信息</a>
							</td>
						</tr>
						
						<tr height=20>
                            <td align=middle width=30>
								<img height=9  src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild  href="Educational/list.html"   target="right">我的成绩</a>
							</td>
						</tr>
						 <tr height=20>
                            <td align=middle width=30>
								<img height=9  src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild  href="Educational/Book.html"   target="right">我的书籍</a>
							</td>
						</tr>
						
                        <tr height=4>
                            <td colspan=2></td>
						</tr>
					</table>
						<c:if test="${list==4}">
							<table cellspacing=0 cellpadding=0 width=150 border=0>
                        <tr height=22>
                            <td style="padding-left: 30px" background=./img/menu_bt.jpg>
							   <a     class=menuparent onclick=expand(4)    href="javascript:void(0);">学习中心</a>
							 </td>
						</tr>
                        <tr height=4>
                            <td></td>
						</tr>
					</table>
						</c:if>
							<table id=child4 style="display: none" cellspacing=0 cellpadding=0  width=150 border=0>
                        <tr height=20>
                            <td align=middle width=30>
								<img height=9  src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild  href="study/StudentMaterial.html"   target="right">资料下载</a>
							</td>
						</tr>
                       
                        <tr height=4>
                            <td colspan=2></td>
						</tr>
					</table>

						<c:if test="${list==5}">
							<table cellspacing=0 cellpadding=0 width=150 border=0>
                        <tr height=22>
                            <td style="padding-left: 30px" background=./img/menu_bt.jpg>
							   <a     class=menuparent onclick=expand(5)    href="javascript:void(0);">资料管理</a>
							 </td>
						</tr>
                        <tr height=4>
                            <td></td>
						</tr>
					</table>
						</c:if>
							<table id=child5 style="display: none" cellspacing=0 cellpadding=0  width=150 border=0>
                        <tr height=20>
                            <td align=middle width=30>
								<img height=9  src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild  href="book/list-ziliao.html"   target=right >资料上传</a>
							</td>
						</tr>
                        <tr height=20>
                            <td align=middle width=30>
								<img height=9  src="./img/menu_icon.gif" width=9>
							</td>
                            <td>
								<a class=menuchild  href="book/list.html"   target=right >书籍管理</a>
							</td>
						</tr>
                     </table>

						<c:if test="${list==6}">
							<table cellspacing=0 cellpadding=0 width=150 border=0>
                        <tr height=22>
                            <td style="padding-left: 30px" background=./img/menu_bt.jpg>
							   <a     class=menuparent    href="javascript:void(0);">权限管理</a>
							 </td>
						</tr>
                        <tr height=4>
                            <td></td>
						</tr>
					</table>
						</c:if>
							<table id=child7  cellspacing=0 cellpadding=0  width=150 border=0>
								<c:if test="${list==7}">
								<tr height=20>
									<td align=middle width=30>
										<img height=9 src="./img/menu_icon.gif" width=9>
									</td>
									<td>
										<a
											type="hidden" class=menuchild href="/getuser" target="right">用户管理</a>
									</td>
								</tr>
								</c:if>
								<c:if test="${list==8}">
								<tr height=20>
									<td align=middle width=30>
										<img height=9 src="./img/menu_icon.gif" width=9>
									</td>
									<td>
										<a class=menuchild  href="/getrole"  target="right">角色管理</a>
									</td>
								</tr>
								</c:if>
								<c:if test="${list==9}">
								<tr height=20>
									<td align=middle width=30>
										<img height=9  src="./img/menu_icon.gif" width=9>
									</td>
									<td>
										<a class=menuchild  href="/getmenu"   target="right">菜单管理</a>
									</td>
								</tr>
								</c:if>
								<tr height=4>
									<td colspan=2></td>
								</tr>
					</table>
					</c:forEach>
				</td>
                <td width=1 bgcolor=#d1e6f7></td>
            </tr>
        </table>
    </body>
</html>