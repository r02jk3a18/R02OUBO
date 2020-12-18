<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

</head>
<body>

<div>
<p id="sample"> 　MERRY.CHRISTMS　</p>
</div>
<%
String sKaisi = (String)request.getAttribute("sDiff");
%>

<h1 style =" text-align:center"><font size="10">セールまであと<%=sKaisi %>日！</font></h1>

<style type="text/css">
p#sample{
	 
 background: -webkit-linear-gradient(top, #008000 , #008080 );

background: linear-gradient(to bottom,#008000 ,#008080);
 }
	
	 </style>



    <style type="text/css">
body {
	color: #ffffff;
text-align: center;
background-color:#800000;

	}

    </style>
 

	 
	
<h2>セール抽選会　受付会場</h2>　
<h2>仙台駅前第一デパート</h2>
	<style type="text/css">
	h1{
	font-size: 9px;
	font-family: "Courier New" , Courier, monospce;
	color:#ffffff;
	}
	h2{
	font-size: 20px;
	color:#ffff00;
}
	</style>
	
<form method="post" action="/Page_kuri">
応募者のメールアドレス<input type="email" name="email" placeholder="メールアドレスを入力" disabled /><br/>


7桁の数字A　　　　　 　<input type="number" name="numa" placeholder="7桁の数字A" disabled /><br/>


7桁の数字B　　　　　 　<input type="number" name="numb" placeholder="7桁の数字B" disabled /><br/>


<input type="submit" value="登録する" disabled />
</form>

	<style type="text/css">
input::placeholder {
  color: red;
}

/* IE */
input:-ms-input-placeholder {
  color: red;
}

/* Edge */
input::-ms-input-placeholder {
  color: red;
}

input{

 text-indent: 1em;
  width: 100%;


}
	</style>
	<div class="flowchart">　</div>	
	<div class="flowchart">　</div>	
<div class="flowchart">★</div>	
<div class="flowchar">●●●</div>	
<div class="flowchar">●●●●</div>	
<div class="flowchar">●●●●●</div>	
<div class="flowchar">●●●●●●</div>	
<div class="flowchar">●●●●●●●</div>	
<div class="flowchar">●●●●●●●●</div>	

<style type="text/css">
.flowchart{

 border-right: 40px solid transparent;
  border-bottom-width: 30px solid #008000;
  border-left: 40px solid transparent; 
font-size:30px;
color:#ffff00;
}
.flowchar{
color:#008000;

}


</style>

</body>
</html>
