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
	String diff = (String)request.getAttribute("sDiff");
	if(Error != null && Error.equals("Same")){
%>
<p>既に存在している数字の組み合わせが入力されたので再入力をしてください</p>
<% }else if(Error != null && Error.equals("Num")){%>
	<p>A,C,E,G,Iのどれかが不正な形式です</p>
<% }%>

<% if(diff != null){%>
	<% int iDiff=Integer.parseInt(diff);%>
	<% iDiff=iDiff*-1;%>
<% 
	if(iDiff <= 10 && iDiff > 0){
%>
	応募期限まで<%=iDiff %>日
	<% }%>
<% }%>
<form method="post" action="./Page2MultiCheck">
応募者のメールアドレス<input type="email" name="email" placeholder="メールアドレスを入力" /><br/>
7桁の数字A<input type="number" name="numa" placeholder="7桁の数字A" /><br/>
7桁の数字B<input type="number" name="numb" placeholder="7桁の数字B" /><br/>
7桁の数字C<input type="number" name="numc" placeholder="7桁の数字C" /><br/>
7桁の数字D<input type="number" name="numd" placeholder="7桁の数字D" /><br/>
7桁の数字E<input type="number" name="nume" placeholder="7桁の数字E" /><br/>
7桁の数字F<input type="number" name="numf" placeholder="7桁の数字F" /><br/>
7桁の数字G<input type="number" name="numg" placeholder="7桁の数字G" /><br/>
7桁の数字H<input type="number" name="numh" placeholder="7桁の数字H" /><br/>
7桁の数字I<input type="number" name="numi" placeholder="7桁の数字I" /><br/>
7桁の数字J<input type="number" name="numj" placeholder="7桁の数字J" /><br/>
<input type="submit" value="登録する" />
</form>


</body>
</html>