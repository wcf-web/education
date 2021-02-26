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
	<input type="hidden" value="${classid}" name="classid"/>
	<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：教务中心-》书籍发放</span> <span
			style="float: right; margin-right: 8px; font-weight: lighter">
            <a style="text-decoration: blink" href="add.html">【发放新书】&emsp;&emsp;&emsp;&emsp;</a>
		</span>
		</span>
	</div>

	<div class="cztable">
		<div>
			
			<ul class="seachform1">
				<form action="#" method="post">
					<li>
						<label>书籍编号</label>
						<input name="name" type="text" class="scinput1" value=""/>&nbsp;&nbsp;
                        <label>学员名称</label>
						<input name="name" type="text" class="scinput1" value=""/>&nbsp;&nbsp;
						<input  type="submit" class="scbtn" value="查询"/>&nbsp;
					</li>
						
				</form>

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody><tr style="font-weight: bold;">
                		<th  width="8%">
						<input type="checkbox"/>
						</th>
                        <th >书籍编号</th>
						<th width="">书籍名称</th>
						<th width="">学员姓名</th>
                        <th width="15%">发送状态</th>						
						<th width="20%">操作</th>  
                    </tr>

                    <tr id="product1">
                    	<td  width="8%" align="center">
						<input type="checkbox"/>
						</td>
                        <td align="center">102553</td>
						<td align="center">java</td>
                        <td align="center">李红</td>
						<td align="center">已收到</td>
						<td align="center">
                        	<a href="info.html">书籍详情</a>

						</td>
                    </tr> 
                    <tr id="product1">
                    	<td  width="8%" align="center">
						<input type="checkbox"/>
						</td>
                        <td align="center">102553</td>
						<td align="center">java</td>
                        <td align="center">李红</td>
						<td align="center">有异议</td>
						<td align="center">
                        	<a href="info.html">详情</a>
                        	<a href="javascript:alert('操作成功！');">核实再发</a>
						</td>
                    </tr> 
                    <tr id="product1">
                    	<td  width="8%" align="center">
						<input type="checkbox"/>
						</td>
                        <td align="center">102553</td>
						<td align="center">java</td>
                        <td align="center">李红</td>
						<td align="center">已收到</td>
						<td align="center">
                        	<a href="info.html">详情</a>
                        	<a href="javascript:'alert('操作成功！');'">核实再发</a>
						</td>
                    </tr> 
					
                    <tr>
                        <td colspan="20" style="text-align: center;">						
						<a style="text-decoration: none;" href="#">
                            首页 上一页  ... 7 8 9 10 11 12 ... 下一页 尾页 共1234条 每页显示 10/23 </a>
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
