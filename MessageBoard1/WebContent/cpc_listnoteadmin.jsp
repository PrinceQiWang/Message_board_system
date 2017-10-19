<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cpc.message.ListNoteBean"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>留言列表</title>
<script type="text/javascript">
	function check(form) {
		if (form.keyword.value == "") {
			alert("查询条件不能为空");
			return false;
		}
	}
</script>
</head>
<body>
	<p align="center">留言板</p>
	<p align="center">留言管理列表</p>
	<form action="SearchServlet" method="post" onsubmit="return check(this)">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		请您输入查询内容：<input type="text" name="keyword" id="keyword"  />
		&nbsp;&nbsp;<input type="submit" value="模糊查询" />
	</form>
	<table width="816" height="137" border="1" align="center">
		<tr>
			<td width="86">留言编号</td>
			<td width="115">标题</td>
			<td width="115">作者</td>
			<td width="291">内容</td>
			<td width="291">回复</td>
			<td width="99">操作</td>
		</tr>
		<%
			List<ListNoteBean>list=(List<ListNoteBean>)request.getAttribute("list");
			if (list == null || list.size() < 1) {
				out.print("<tr><td bgcolor='#FFFFFF' colspan='5'>没有任何留信息！</td></tr>");
			} else {
				for (ListNoteBean note : list) {
		%>
		
		<tr>
			<td><%=note.getId()%></td>
			<td><%=note.getTitle()%></td>
			<td><%=note.getAuthor()%></td>
			<td><%=note.getContent()%></td>
			<td><%=note.getReply()%></td>
			<td><a href="ReplyServlet?id=<%=note.getId()%>&value1=<%=request.getAttribute("value1")%>">回复</a>
			    <a href="DeleteServlet?id=<%=note.getId()%>&value1=<%=request.getAttribute("value1")%>">删除</a></td>
		</tr>
		<%
			}
			}
		%>
</table>
	<p align="center">
		<strong><a href="cpc_insert.jsp?value1=<%=request.getAttribute("value1")%>">添加新留言</a></strong>
	</p>
	<p>&nbsp;</p>
</body></html>
