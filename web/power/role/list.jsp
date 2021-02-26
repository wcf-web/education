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
        function del(rid){
            var flag = confirm("确认操作？");
            if(flag==true){
                location.href="/deleterole?roleid="+rid;
            }
        }
</script>
</head>
<body>

   

<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：权限管理-》角色管理</span> <span
			style="float:right;margin-right: 8px;font-weight: bold">
			<a style="text-decoration: none;" href="/getallmenuofrole">【新增角色】</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</span>
		</span>
	</div>

<div class="morebt">
 
</div>





 <div class="cztable">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                	<th><input type="checkbox"/></th>
                    <th scope="col">
                        序号
                    </th>
                    
                    <th scope="col">
                        角色名称
                    </th>
                    <th scope="col">
                        状态
                    </th>
                    <th scope="col" width="300px">
                        操作
                    </th>
                </tr>
                
               
                <c:forEach items="${rlist}" var="list">
                    <tr align="center">
                        <th><input type="checkbox"/></th>
                        <td>
                            ${list.roleId}
                        </td>
                        <td>
                           ${list.roleName}
                        </td>
                        <c:if test="${list.roleStatus==1}">
                            <td>&nbsp;
                                启用
                            </td>
                            <td>&nbsp;
                                <a href="/disablerole.do?roleid=${list.roleId}">禁用</a>
                                <a href="/showrolemessage?roleid=${list.roleId}">详情</a>
                                <a href="/getrolemessageforupdate?roleid=${list.roleId}">修改</a>
                                <a href="javascript:void(0)" onclick="del(${list.roleId})" class="tablelink"> 删除</a>
                            </td>
                        </c:if>
                        <c:if test="${list.roleStatus==0}">
                            <td>&nbsp;
                                禁用
                            </td>
                            <td>&nbsp;
                                <a href="/enablerole.do?roleid=${list.roleId}">启用</a>
                                <a href="/showrolemessage?roleid=${list.roleId}">详情</a>
                                <a href="/getrolemessageforupdate?roleid=${list.roleId}">修改</a>
                                <a href="javascript:void(0)" onclick="del(${list.roleId})" class="tablelink"> 删除</a>
                            </td>
                        </c:if>

                    </tr>
                </c:forEach>
                
            </tbody>
        </table>
        

    </div>

    </div>
</body>
</html>