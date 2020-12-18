<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body background ="file:///Z:/git/R02OUBO/WebContent/WEB-INF/img/無題.png">
<body bgcolor = "#FFCCFF" text ="#ff1493" >
<body  text ="#000000" >
<%
String sKaisi = (String)request.getAttribute("sDiff");
%>
<br >
<br >
<br >
<br >
<br >
<h1 style =" text-align:center"><font size="10">セールまであと<%=sKaisi %>日！</font></h1>
<br >
<br >
<h1 style =" text-align:center">仙台駅前第一デパート　セール抽選会　受付会場</h1>


<form method="post" action="./page2">
<div style =" text-align:center">

<font size="5">応募者のメールアドレス</font>
<input type="email" name="email" placeholder="メールアドレスを入力" disabled /><br/>
<br/>
<font size="5">   7 桁 の 数 字  A  </font>
<input type="number" name="numa" placeholder="7桁の数字A" disabled /><br/>
<br/>
<font size="5">   7 桁 の 数 字  B  </font>
<input type="number" name="numb" placeholder="7桁の数字B" disabled /><br/>
<br/>
<br/>
<input type="submit" value="登録する" style ="width:100px;height:50px" disabled />

</div >
</form>

</body>
</html>
