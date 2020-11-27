<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tousen</title>
</head>
<body>
<%
	List<String[]>  list	=	(List<String[]>)request.getAttribute("Tousen");
%> 
<table>
<tr><th>当選者アドレス</th><th>当選商品</th></tr>
<%
	for(String[] s:list){ 
%>
<tr>
		<td><%=s[0] %></td>
		<td><%=s[1] %></td>
</tr>
<%
	} 
%>
</table>
</body>
</html>