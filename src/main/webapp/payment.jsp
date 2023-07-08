<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="payment" method="post">
		Expiry Date <input type="date" name="expd" placeholder="Enter your username"><br>
		<br>
		CVC <input type="password" name="cvc" placeholder="Enter your password"><br>
		<br><input type="submit" name="submit" value="Show Payment Details">
	</form>
	
</body>
</html>