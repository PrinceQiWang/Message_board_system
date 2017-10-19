<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cpc.message.ListNoteBean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>	
<head>
<title>回复留言</title>
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
	
    <form id="form1" name="form1" method="post" action="ReplyServlet2">
<p align="center" class="STYLE1">留言板</p>
	<p align="center" class="STYLE2">回复留言</p>
<table width="816" height="137" border="1" align="center">
		<tr>
			<td width="86" >留言编号</td>
			<td width="179">标题</td>
			<td width="115">作者</td>
			<td width="291">内容</td>
		</tr>
		<%
			List<ListNoteBean> list = 
              (List<ListNoteBean>) request.getAttribute("list");
				for (ListNoteBean note : list) {
		%>
		<tr>
		<td><%=note.getId()%></td><input type="hidden"name="id" value=<%=note.getId()%> >
			<td><%=note.getTitle()%></td>
			<td><%=note.getAuthor()%></td>
			<td><%=note.getContent()%></td>
		</tr>
		<%
			}
		%>
		</table>
		<table width="816" height="162" border="1" align="center">
		<tr>
		<td>内容：</td>
		<input type="hidden" name="value1" value=<%=request.getParameter("value1") %>></input>
				<td><label> <textarea name="reply" cols="91"
							rows="10" id="reply"></textarea>
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
			
			</form>
	<center>
		<h3>
			<a href="javascript:history.back(-1);">返回留言管理列表</a>
		</h3>
	</center>
<p>&nbsp;</p>
</body>
</html>