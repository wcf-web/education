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
	function del(){
		confirm("确认删除？");
	}

</script>



</head>
<body>
	
	<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：教务中心-》考试</span> <span
			style="float:right;margin-right: 8px;font-weight: bold"> <a
				style="text-decoration: none" href="/getcollegeforexam.do">【新增考试】</a>
		</span>
		</span>
	</div>

	<div class="cztable">
		<div>
			
			<ul class="seachform1">
				<form action="/getexam" method="post">
					<li>
						<label>考试科目</label>
						<input name="examname" type="text" class="scinput1" value="${examname}"/>&nbsp;&nbsp;
						<input  type="submit" class="scbtn" value="查询"/>&nbsp;
					</li>
						
				</form>

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr style="height: 25px" align="center">
					<th scope="col">编号</th>
					<th scope="col">考试编号</th>
					<th scope="col">考试科目</th>
					<th scope="col">考试时间</th>
					<th scope="col">考试班级</th>
					<th scope="col">考试状态</th>
					<th scope="col">操作</th>
				</tr>
				<c:forEach items="${elist}" var="list">
					<tr align="center">
						<td>${list.examId}</td>
						<td>${list.examNo}</td>
						<td>${list.examSubject}</td>
						<td>${list.examTime}</td>
						<td>${list.aClass.classNo}</td>
						<c:if test="${list.examState==1}">
							<td align="center">未考试</td>
							<td>
								<a href="/getexammessage?examid=${list.examId}">详细</a>
							</td>
						</c:if>
						<c:if test="${list.examState==2}">
							<td align="center">考试中</td>
							<td>
								<a href="/getexammessage?examid=${list.examId}">详细</a>
							</td>
						</c:if>
						<c:if test="${list.examState==3}">
							<td align="center">已考完</td>
							<td>
								<a href="/getexammessage?examid=${list.examId}">详细</a>
								<a href="/getexammessage?examid=${list.examId}">成绩</a>
							</td>
							</td>
						</c:if>

					</tr>
				</c:forEach>

				<tr>
					<td colspan="20" style="text-align: center;">
						<a style="text-decoration: none;" href="/getexam?index=1&&examname=${examname}">首页</a>
						<a style="text-decoration: none;" href="/getexam?index=${pindex-1<=0?1:pindex-1}&&examname=${examname}">上一页</a>
						<a style="text-decoration: none;" href="/getexam?index=${pindex+1>=totalpage?totalpage:pindex+1}&&examname=${examname}">下一页</a>
						<a style="text-decoration: none;" href="/getexam?index=${totalpage}&&examname=${examname} ">尾页</a>
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
