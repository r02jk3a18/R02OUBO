<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String Email = (String)request.getAttribute("email");
String Numa = (String)request.getAttribute("numa");
String Numb = (String)request.getAttribute("numb");
%>
<p>こちらで登録してよいですか?</p>
<p>応募者のメールアドレス <%=Email%></p>
<p>7桁の数字A <%=Numa%></p>
<p>7桁の数字B <%=Numb%></p>
<form method="post" action="./page2Insert">
<input type="hidden" name="email" value="<%=Email%>" /><br/>
<input type="hidden" name="numa" value="<%=Numa%>" /><br/>
<input type="hidden" name="numb" value="<%=Numb%>"> <br/>
<input type="submit" value="はい" />
</form>
<button type=“button” onclick="location.href='./index'">いいえ</button>
</body>
</html>