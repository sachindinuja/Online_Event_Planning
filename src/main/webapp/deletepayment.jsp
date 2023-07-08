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
		String paymentId = request.getParameter("paymentId");
		String  cardHoldersName= request.getParameter("cardHoldersName");
		String paymentMethod = request.getParameter("paymentMethod");
		String cardNumber = request.getParameter("cardNumber");
		String expDate = request.getParameter("expDate");
		String cvc =request.getParameter("cvc");
		%>
	
	
	<form action="deletePay" method="post">
		Payment ID <input type="text" name="pid" value="<%= paymentId %>" readonly><br>
		Card Holders Name <input type="text" name="chname" value="<%= cardHoldersName %>"><br>
		Payment Method <input type="text" name="pm" value="<%= paymentMethod %>"><br>
		Card Number <input type="text" name="cno" value="<%= cardNumber %>"><br>
		Expiry Date <input type="date" name="exp" value="<%= expDate %>"><br>
		CVC	<input type="text" name="cvc" value="<%= cvc %>"><br>
		
		
		<input type="submit" name="submit" value="Delete Payment Data">
	</form>
</body>
</html>