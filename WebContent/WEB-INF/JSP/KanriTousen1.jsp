<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>当選番号登録</h1>

<form method="post" action="./KanriTousen2">
7桁の数字A<input type="number" name="numa" placeholder="7桁の数字A" /><br/>
7桁の数字B<input type="number" name="numb" placeholder="7桁の数字B" /><br/>
商品<input type="text" name="text" placeholder="当選した商品" /><br/>
<input type="submit" value="登録する" />
</form>
</body>
</html>