<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>
    <script>
        function del(uid,role){
            var flag = confirm("确认操作？");
            if(flag==true){
                location.href="/deleteuser?userid="+uid+"&&role="+role;
            }
        }
	</script>

</head>
<body>


<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：权限管理-》人员管理</span> <span
			style="float:right;margin-right: 8px;font-weight: bold">
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a style="text-decoration: none;" href="javascript:alert('操作成功！');">【批量删除】</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a style="text-decoration: none;" href="/getallrole">【新增人员】</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</span>
		</span>
	</div>

<div class="morebt">
 
</div>
 <div class="cztable" style="width: 100%;">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px;" align="center">
                    
                    <th  width="8%">
						<input type="checkbox"/>
					</th>
                    <th scope="col" width="15%">
                        编号
                    </th>
                    <th scope="col" width="15%">
                        用户名
                    </th>
                    <th scope="col" width="15%">
                        姓名
                    </th>
                    <th scope="col" width="15%">
                        角色
                    </th>
                   
                    <th scope="col" >
                        操作
                    </th>
                </tr>
                
               
                <c:forEach items="${ulist}" var="list">
                    <tr align="center">
                        <th><input type="checkbox"/></th>

                        <td>
                                ${list.userId}
                        </td>
                        <td>
                          ${list.account}
                        </td>
                        <td>
                           <a href="/getmessage?userid=${list.userId}">${list.username}</a>
                        </td>

                        <c:if test="${list.role==1}">
                            <td>&nbsp;管理员</td>
                        </c:if>
                        <c:if test="${list.role==2}">
                            <td>&nbsp;主任</td>
                        </c:if>
                        <c:if test="${list.role==3}">
                            <td>&nbsp;老师</td>
                        </c:if>
                        <c:if test="${list.role==4}">
                            <td>&nbsp;学生</td>
                        </c:if>

                        <td>&nbsp;
                            <a href="/updateuser?userrole=${list.role}">修改</a>
                            <a href="javascript:void(0)" onclick="del(${list.role},${list.userId})" class="tablelink"> 删除</a>
                        </td>
                    </tr>
                </c:forEach>

               
                
                
            </tbody>
        </table>
        

    </div>

        
        

    </div>
</body>
</html>