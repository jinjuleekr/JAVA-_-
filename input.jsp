<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="vending">
<h1>음료 자판기</h1>	<!-- type="number"는 html 5부터 지원 -->
금액 입력<input type="number" min="0" max="10000" name="inputMoney" value="5000">
<p>상품을 입력하세요</p>
콜라(500원) <input type="checkbox" name="item" value="콜라(500원)"><br>
사이다(600원) <input type="checkbox" name="item" value="사이다(600원)"><br>
환타(500원) <input type="checkbox" name="item" value="환타(500원)"><br>
밀키스(700원) <input type="checkbox" name="item" value="밀키스(700원)"><br>
봉봉(900원) <input type="checkbox" name="item" value="봉봉(900원)"><br>
멕스웰(400원) <input type="checkbox" name="item" value="맥스웰(400원)"><br>
<input type="submit" value="주문">
<input type="reset" value="다시입력">
</form>
</body>
</html>
