﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    

</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》书籍管理-》发放新书</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="/addbook" method="post">
        <input type="hidden" name="classid" value="${classid}"/>
	<table border="1" width="100%" class="table_a">

				<tr>
                    <td>书籍编号：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text" name="bookno" value="" /></td>
                </tr>
                <tr>
                    <td>书籍名称：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text" name="bookname" value="" /></td>
                </tr>
				


                <tr>
                    <td>简介<span style="color:red">*</span>：</td>
                    <td>
                        <textarea name="content"></textarea>
                    </td>
                </tr>
				

				
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="保存" />
                        <input type="button" value="返回" onclick="javascript:history.back();"/>
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
