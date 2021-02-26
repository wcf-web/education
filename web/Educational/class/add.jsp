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
    <script type="">
        $(function () {
            // 得到学院的id，通过学院的id查询到该学院的所有专业
            $("#sid").change(function () {
                // 1.得到value值
                var college = $(this).val();
                // 2.发送 ajax请求
                $.ajax({
                    url:"/getmajor",
                    data:"collegeid="+college,
                    dataType:"JSON",
                    type:"post",
                    success:function (result) {
                        $("#mid")[0].length=0;//清空下拉框
                        result = eval("("+result+")");
                        // 返回json数据，处理结果集
                        for(var i=0;i<result.length;i++){
                            // 将json转换成可读取的json,将json字符串转换成json对象
                            $("#mid")[0].add(new Option(result[i].majorName,result[i].majorId));
                        }
                    }

                })
            })

        })
    </script>
</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》班级管理-》新增</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="/addclass" method="post">
	<table border="1" width="100%" class="table_a">
                
                <tr>
                    <td  width="120px;">班级编号：<span style="color:red">*</span>：</td>
                    <td>
                       <input type="text" name="classno"/>
                    </td>
                </tr>
               
               <tr>
                    <td>学院<span style="color:red">*</span>：</td>
                    <td>
                        <select name="collegeid" id="sid">
                            <c:forEach items="${collegeList}" var="list">
                                <option value="${list.collegeId}">${list.collegeName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>专业<span style="color:red">*</span>：</td>
                    <td>
                        <select id="mid" name="majorid">
                        	<option>--请选择--</option>
                        </select>
                    </td>
                </tr>
               
                <tr>
                    <td>班级名称：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text" name="classname"/></td>
                </tr>
				
				 <tr>
                    <td>开班时间：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text" name="startdate"/></td>
                </tr>
                <tr>
                    <td>毕业时间：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text" name="enddate"/></td>
                </tr>
                <tr>
                    <td>班级人数：<span style="color:red">*</span>：</td>
                    <td>
                        <input type="text" name="classnum"/></td>
                </tr>
                <tr>
                    <td>班主任ID：<span style="color:red">*</span>：</td>
                    <td>
                        <input type="text" name="teacherid"/></td>
                </tr>
				


                <tr>
                    <td>简介<span style="color:red">*</span>：</td>
                    <td>
                        <textarea name="content"></textarea>
                    </td>
                </tr>
				

				
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="保存">
                    </td>
                </tr>  
            </table>
	</form>
</div>

            </div>
        </div>
    </div>
</body>
</html>
