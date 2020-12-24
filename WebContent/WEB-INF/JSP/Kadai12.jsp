<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>管理者用応募者メールアドレス表示画面</h1>

<%
        List<String[]> list = 
                (List<String[]>)request.getAttribute("result");
%>
<table border=1>
<TR>
<TH>EMAIL</TH>
</TR>
<% 
        for(String[] s: list){
%>

        <tr>
                <TD><%= s[0] %></TD>
        </tr>
<%
        }
%>
</table>

