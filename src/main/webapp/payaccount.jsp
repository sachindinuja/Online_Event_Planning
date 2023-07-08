<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<table border="2px">
		<c:forEach var = "paym" items = "${paymentDetails}">
		
		<c:set var="paymentId" value="${paym.paymentId}"/>
		<c:set var="cardHoldersName" value="${paym.cardHoldersName}"/>
		<c:set var="paymentMethod" value="${paym.paymentMethod}"/>
		<c:set var="cardNumber" value="${paym.cardNumber}"/>
		<c:set var="expDate" value="${paym.expDate}"/>
		<c:set var="cvc" value="${paym.cvc}"/>
	
		<tr>
			<td>Payment ID</td>
			<td>${paym.paymentId}</td>
		</tr>	
		<tr>
			<td>Card Holder's Name</td>
			<td>${paym.cardHoldersName}</td>
		</tr>
		<tr>
			<td>Payment Method</td>
			<td>${paym.paymentMethod}</td>
		</tr>
		<tr>
			<td>Card Number</td>
			<td>${paym.cardNumber}</td>
		</tr>
		<tr>
			<td>Expiry Date</td>
			<td>${paym.expDate}</td>
		</tr>
		<tr>
			<td>CVV</td>
			<td>${paym.cvc}</td>
		</tr>
		</c:forEach>
	</table>
	
	<c:url value="updatepayment.jsp" var="payUpdate">
	
		<c:param name="paymentId" value="${paymentId}"/>
		<c:param name="cardHoldersName" value="${cardHoldersName}"/>
		<c:param name="paymentMethod" value="${paymentMethod}"/>
		<c:param name="cardNumber" value="${cardNumber}"/>
		<c:param name="expDate" value="${expDate}"/>
		<c:param name="cvc" value="${cvc}"/>
		
	</c:url>
	
	<a href="${payUpdate}">
	
		<input type="button" name="update" value="Update Data">
		
	</a>
	
	<c:url value="deletepayment.jsp" var="paydelete">
	
		<c:param name="paymentId" value="${paymentId}"/>
		<c:param name="cardHoldersName" value="${cardHoldersName}"/>
		<c:param name="paymentMethod" value="${paymentMethod}"/>
		<c:param name="cardNumber" value="${cardNumber}"/>
		<c:param name="expDate" value="${expDate}"/>
		<c:param name="cvc" value="${cvc}"/>
		
	</c:url>
	
	<a href="${paydelete}">
	
		<input type="button" name="delete" value="Delete Data">
		
	</a>
</body>
</html>