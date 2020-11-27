<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>仙台駅前第一デパート　セール抽選会　受付会場</h1>
<%
	String Error = (String)request.getAttribute("Error");
	if(Error != null){
%>
<p>既に存在している数字の組み合わせが入力されたので再入力をしてください</p>
<% }%>
<form method="post" action="./Page2Check">
応募者のメールアドレス<input type="email" name="email" placeholder="メールアドレスを入力" /><br/>
7桁の数字A<input type="number" name="numa" placeholder="7桁の数字A" /><br/>
7桁の数字B<input type="number" name="numb" placeholder="7桁の数字B" /><br/>
<input type="submit" value="登録する" />
</form>


</body>
</html>