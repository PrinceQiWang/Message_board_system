<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cpc.message.ListNoteBean"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
</head>
<body>
	<table width="816" height="137" border="1" align="center">
		<tr>
			<td width="86">留言编号</td>
			<td width="179">标题</td>
			<td width="115">作者</td>
			<td width="291">内容</td>
			<td width="291">回复</td>
		</tr>
	<%
		List<ListNoteBean> list = (List<ListNoteBean>)request.getAttribute("list");
		if (list == null || list.size() < 1) {
			out.print("<tr><td bgcolor='#FFFFFF' colspan='5'>没有查询内容！</td></tr>");
		} else {
			for (ListNoteBean note : list) {
	%>
		<tr>
			<td><%=note.getId()%></td>
			<td><%=note.getTitle()%></td>
			<td><%=note.getAuthor()%></td>
			<td><%=note.getContent()%></td>
			<td><%=note.getReply()%></td>
		</tr>
<%
		}
		}
	%>
	</table>
	<p align="center">
		<strong><a href="javascript:history.back(-1);">返回留言列表</a></strong>
	</p>
</body>
</html>