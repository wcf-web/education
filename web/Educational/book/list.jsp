<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../Script/Common.js" type="text/javascript"></script>
    <script src="../Script/Data.js" type="text/javascript"></script>
    <script>
        // 根据图书id对图书进行假删除
        function del(sid){
            var flag = confirm("确认操作？");
            if(flag==true){
                location.href="/deletebook?bookid="+sid+"&&classid=${classid}";
            }
        }

</script>
</head>
<body>



<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：书籍管理</span> <span
			style="float:right;margin-right: 8px;font-weight: bold">
            <a style="text-decoration: none;" href="javascript:alert('操作成功！');">【导出excel】</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a style="text-decoration: none;" href="/saveid?classid=${classid}">【新增书籍】</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</span>
		</span>
	</div>

<div class="morebt">
</div>
<form action="">
    <input type="hidden" name="classid" value="${classid}"/>
</form>

 <div class="cztable">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                	<th><input type="checkbox"/></th>
                    <th scope="col">
                        编号
                    </th>
                    
                    <th scope="col">
                        书籍名称
                    </th>
                    <th scope="col">
                        状态
                    </th>
                    <th scope="col">
                        操作
                    </th>
                </tr>
                
               
                <c:forEach items="${blist}" var="list">
                    <tr align="center">
                        <th><input type="checkbox"/></th>
                        <td>
                            ${list.bookNo}
                        </td>
                        <td>
                           ${list.bookName}
                        </td>

                        <c:if test="${list.bookStatus==1}">
                            <td align="center">启用</td>
                            <td>&nbsp;
                                <a href="/disable.do?bookid=${list.bookId}&&classid=${classid}">禁用</a>
                                <a href="javascript:void(0)" onclick="del(${list.bookId})" class="tablelink"> 删除</a>
                            </td>
                        </c:if>
                        <c:if test="${list.bookStatus==0}">
                            <td align="center">禁用</td>
                            <td>&nbsp;
                                <a href="/able.do?bookid=${list.bookId}&&classid=${classid}">启用</a>
                                <a href="javascript:void(0)" onclick="del();return false" class="tablelink"> 删除</a>
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