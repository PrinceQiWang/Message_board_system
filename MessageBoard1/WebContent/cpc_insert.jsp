<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>添加新留言</title>
<script type="text/javascript">
	function check(form) {
		if (form.title.value == "") {
			alert("请填写留言标题");
			return false;
		}
		if (form.author.value == "") {
			alert("请填写你的名字");
			return false;
		}
		if (form.content.value == "") {
			alert("你还没写留言内容呐！");
			return false;
		}
	return true;
	}
	</script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
<!--
.STYLE1 {
	color: #000000;
	font-weight: bold;
	font-size: 36px;
	font-family: "楷体_GB2312";
}
.STYLE2 {
	font-family: "Courier New", Courier, monospace;
	font-size: 16px;
	font-weight: bold;
	color: #000000;
}
-->
</style>
</head>
<body>
	<p align="center" class="STYLE1">留言板</p>
	<p align="center" class="STYLE2">添加新留言</p>
	<form id="form1" name="form1" method="post" onsubmit=" return check(this)" action="InsertServlet">
	<input type="hidden" name="value1" value=<%=request.getParameter("value1") %>></input>
		<table width="551" height="162" border="1" align="center">
			<tr>
				<td width="76">标题：</td>
				
				<td width="358"><label> <input name="title" type="text"
						id="title" size="40" maxlength="40" />
				</label></td>
			</tr>
			<tr>
				<td>作者：</td>
				<td><label> <input name="author" type="text"
						id="author" size="20" maxlength="20" />
				</label></td>
			</tr>
			<tr>
				<td>内容：</td>
				<td><label> <textarea name="content" cols="50"
							rows="10" id="content"></textarea>
				</label></td>
			</tr>
			<tr>
				<td><label> <input type="submit" name="submit"
						id="submit" value="提交" />
				</label></td>
				<td><label> <input type="reset" name="reset" id="reset"
						value="重置" />
				</label></td>
			</tr>
		</table>
		<center>
			<h3>
				<a href="javascript:history.back(-1);">返回留言列表</a>
			</h3>
		</center>
	</form>
	<p>&nbsp;</p>
</body>
</html>