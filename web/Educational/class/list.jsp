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
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
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
		<span> <span style="float:left">当前位置是：教务中心-》班级管理</span> <span
			style="float: right; margin-right: 8px; font-weight: lighter">
            <a style="text-decoration: blink" href="javascript:alert('操作成功！');">【导出excel】&nbsp;&nbsp;</a>
            <a style="text-decoration: blink" href="/getcollegeforclass.do">【新增班级】&emsp;&emsp;&emsp;&emsp;</a>
		</span>
		</span>
	</div>

	<div class="cztable">
		<div>
			
			<ul class="seachform1">
				<form action="/getclasses" method="post">
					<li>
						班级名称:
						<input name="classname" type="text" class="scinput1" value="${name}"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input  type="submit" class="scbtn" value="查询"/>&nbsp;
					</li>
						
				</form>

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody><tr style="font-weight: bold;">
                		<th  width="8%">
						<input type="checkbox"/>
						</th>
                        <th >院系</th>
						<th width="">班级编号</th>
						<th width="">班级名称</th>
                        <th width="15%">班主任老师</th>						
                        <th width="15%">人数</th>
						<th width="15%">班级状态</th>
						<th width="20%">操作</th>  
                    </tr>
				<c:forEach items="${clist}" var="list">
                    <tr id="product1">

                    	<td  width="8%" align="center">
						<input type="checkbox"/>
						</td>
								<td align="center">${list.major.majorName}</td>
								<td align="center">${list.classNo}</td>
								<td align="center">${list.className}</td>
								<td align="center">${list.teacher.teacherName}</td>
								<td align="center">${list.classNum}</td>
								<c:if test="${list.classStatus==1}">
									<td align="center">审核中</td>
									<td align="center">
										<a href="/intoclass?classid=${list.classId}">详情</a>
									</td>
								</c:if>
								<c:if test="${list.classStatus==2}">
									<td align="center">正常</td>
									<td align="center">
										<a href="/intoclass?classid=${list.classId}">详情</a>
										<a href="/getbook?classid=${list.classId}">发书</a>
									</td>
								</c:if>
								<c:if test="${list.classStatus==3}">
									<td align="center">审核未通过</td>
									<td align="center">
										<a href="/intoclass?classid=${list.classId}">详情</a>
									</td>
								</c:if>
								<c:if test="${list.classStatus==4}">
									<td align="center">已毕业</td>
									<td align="center">
										<a href="/intoclass?classid=${list.classId}">详情</a>
									</td>
								</c:if>


							<br/>
                    </tr>
				</c:forEach>
					
                    <tr>
                        <td colspan="20" style="text-align: center;">
							<a style="text-decoration: none;" href="/getclasses?index=1&&classname=${name}">首页</a>
							<a style="text-decoration: none;" href="/getclasses?index=${pindex-1<=0?1:pindex-1}&&classname=${name}">上一页</a>
							<a style="text-decoration: none;" href="/getclasses?index=${pindex+1>=totalpage?totalpage:pindex+1}&&classname=${name}">下一页</a>
							<a style="text-decoration: none;" href="/getclasses?index=${totalpage}&&classname=${name} ">尾页</a>
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
