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
String Numc = (String)request.getAttribute("numc");
String Numd = (String)request.getAttribute("numd");
String Nume = (String)request.getAttribute("nume");
String Numf = (String)request.getAttribute("numf");
String Numg = (String)request.getAttribute("numg");
String Numh = (String)request.getAttribute("numh");
String Numi = (String)request.getAttribute("numi");
String Numj = (String)request.getAttribute("numj");
%>
<p>こちらで登録してよいですか?</p>
<p>応募者のメールアドレス <%=Email%></p>
<p>7桁の数字A <%=Numa%></p>
<p>7桁の数字B <%=Numb%></p>
<p>7桁の数字C <%=Numc%></p>
<p>7桁の数字D <%=Numd%></p>
<p>7桁の数字E <%=Nume%></p>
<p>7桁の数字F <%=Numf%></p>
<p>7桁の数字G <%=Numg%></p>
<p>7桁の数字H <%=Numh%></p>
<p>7桁の数字I <%=Numi%></p>
<p>7桁の数字J <%=Numj%></p>


<form method="post" action="./page2MultiInsert">
<input type="hidden" name="email" value="<%=Email%>" /><br/>
<input type="hidden" name="numa" value="<%=Numa%>" /><br/>
<input type="hidden" name="numb" value="<%=Numb%>" /><br/>
<input type="hidden" name="numc" value="<%=Numc%>" /><br/>
<input type="hidden" name="numd" value="<%=Numd%>" /><br/>
<input type="hidden" name="nume" value="<%=Nume%>" /><br/>
<input type="hidden" name="numf" value="<%=Numf%>" /><br/>
<input type="hidden" name="numg" value="<%=Numg%>" /><br/>
<input type="hidden" name="numh" value="<%=Numh%>" /><br/>
<input type="hidden" name="numi" value="<%=Numi%>" /><br/>
<input type="hidden" name="numj" value="<%=Numj%>" /><br/>
<input type="submit" value="はい" />
</form>
<button type=“button” onclick="location.href='./Page1Multi'">いいえ</button>
</body>
</html>