<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>用户登录</title>
<script type="text/javascript">
	function check(form) {
		if (form.id.value == "") {
			alert("用户名不能为空");
			return false;
		}
		if (form.password.value == "") {
			alert("密码不能为空");
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
	link rel="stylesheet" type="text/css" href="styles.css">
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
	<p align="center" class="STYLE2">用户登录页面</p>
	<%
		if (request.getAttribute("error") != null) {
	%>
	<center>
		<h3>
			<font color="red"><%=request.getAttribute("error")%></font>
		</h3>
	</center>
	<%
		}
	%>
	<form id="form1" name="form1" method="post"
		onsubmit=" return check(this)" action="LoginServlet">
		<table width="337" height="124" border="1" align="center">
			<tr>
				<td width="77">用户名：</td>
				<td width="107"><label> <input name="name" type="text"
						id="id" size="20" maxlength="20" />
				</label></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;码：</td>
				<td><label> <input name="password" type="password"
						id="password" size="20" maxlength="20" />
				</label></td>
			</tr>
			<tr>
				<td><label> <input type="submit" name="submit"
						id="submit" value="登录" />
				</label></td>
				<td><label> <input type="reset" name="reset" id="reset"
						value="重置" />
				</label> <label> <input type="reset" name="register" id="register"
						value="注册"
						onclick="javascript:document.location.href='cpc_register.jsp';">
				</label></td>

			</tr>
		</table>
	</form>
</body>
</html>
