<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息管理平台</title>
<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
<link href="../../css/mine.css" type="text/css" rel="stylesheet">
<script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="../../Script/jBox/jquery.jBox-2.3.min.js"
	type="text/javascript"></script>
<script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
<script src="../../Script/Common.js" type="text/javascript"></script>
<script src="../../Script/Data.js" type="text/javascript"></script>

<script>
	// 根据学生id对学生进行假删除
	function del(sid){
		var flag = confirm("确认操作？");
		if(flag==true){
			location.href="/deletestudent?stuid="+sid;
		}
	}

</script>



</head>
<body>
	
	<div class="div_head" style="width: 100%;text-align:center;">
		<span>
                <span style="float: left;">当前位置是：教务中心-》学生管理</span>
                <span style="float: right; margin-right: 8px; font-weight: bold;">
                    <a style="text-decoration: none;" href="/getcollegeforstudent.do">【新增学生】</a>&emsp;&emsp;&emsp;&emsp;
                </span>
            </span>
	</div>

	<div class="cztable">
		<div>
				  <form action="/getstudent" method="post">
                    学生名称: 
					<input type="text" name="studentName" value="${name}"/>
                     学生学号: 
					<input type="text" name="studentNo" value="${number}"/>
					性别: 
					<select name="studentSex">
							<option value="-1">--请选择--</option>
							<option value="1">男</option>
							<option value="0">女</option>
						</select>
					<input type="submit" value="查询" />

                </form>

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr style="height: 25px" align="center">
                        <th >学号</th>
						<th width="">姓名</th>
						<th width="">性别</th>
                        <th width="15%">联系电话</th>						
                        <th width="15%">专业</th>
						<th width="15%">登记时间</th>
						<th>操作</th>
                    </tr>
				<c:forEach items="${stulist}" var="stu">
					<tr id="product1">
						<td align="center">${stu.studentNo}</td>
						<td align="center">${stu.studentName}</td>
						<td align="center">${stu.sex}</td>
						<td align="center">${stu.phone}</td>
						<td align="center">${stu.major.majorName}</td>
						<td align="center">${stu.regDate}</td>
						<td align="center">
							<a href="/findstudenttoupdate?stuid=${stu.studentId}">修改</a>
							<a href="javascript:void(0)" onclick="del(${stu.studentId})" class="tablelink"> 退学</a>
							<a href="/showstudentmesssge?stuid=${stu.studentId}">详细</a>
						</td>
					</tr>
				</c:forEach>
				
					
                    <tr>
                        <td colspan="20" style="text-align: center;">						
							<a style="text-decoration: none;" href="/getstudent?index=1&&studentName=${name}&&studentNo=${number}">首页</a>
							<a style="text-decoration: none;" href="/getstudent?index=${pindex-1<=0?1:pindex-1}&&studentName=${name}&&studentNo=${number}">上一页</a>
							<a style="text-decoration: none;" href="/getstudent?index=${pindex+1>=totalpage?totalpage:pindex+1}&&studentName=${name}&&studentNo=${number}">下一页</a>
							<a style="text-decoration: none;" href="/getstudent?index=${totalpage}&&studentName=${name}&&studentNo=${number} ">尾页</a>
							总页数：${totalpage} 总条数：${total} 当前页数:${pindex}

                        </td>
                    </tr>
                </tbody>
            </table>
	</div>

	</div>
	</div>

	</div>
</body>
</html>
