<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="payment.css">
<title>Insert title here</title>
</head>
<body>

		 <nav class="header">
       <h1>Online <span>Event Planning</span> System</h1>
       <ul>
          <li><a class="active" href="home.jsp">Home</a></li>
          <li><a href="event.jsp">Event</a></li>
          <li><a href="contactusinsert.jsp">ContactUs</a></li>
          <li><a href="login.jsp">login</a></li>
        </ul>
    </nav>
	
	<form action="data" method="post">
			
			
	<h4> About the card </h4>
	<br>
			
			<!--  <input type="radio" name="ctype" value="Visa">Visa <img src="Images\card.jpeg"  alt="payment2Image" style="width:5%">
			<input type="radio" name="ctype" value="Master Card">Master Card <img src="Images\master.jpg"  alt="payment2Image" style="width:5%">
			<input type="radio" name="ctype" value="AMERICAN EXPRESS">AMERICAN EXPRESS <img src="Images\american.jpg"  alt="payment2Image" style="width:5%">
			<input type="radio" name="ctype" value="DISCOVER NETWORK">DISCOVER NETWORK <img src="Images\discover.jpg"  alt="payment2Image" style="width:5%"><br/><br>-->

			<label>Cardholder's Name</label>
			<input type="text" name="Cardholder's Name" placeholder="Cardholder's Name"><br><br>
			<label>Payment Method</label>
			<input type="text" name="ctype" placeholder="Visa/Master"><br><br>
			<label>Card Number</label>
			<input type="text" name="Card Number" placeholder="Card Number" required><br><br>
			

			<label>Expiry</label>
			<input type="date" name="expiry"><br><br>
			<label>CVC Number</label>
			<input type="text" name="code" placeholder="code" required><br><br>
			<br><br>
			<a herf="event.jsp">
			<input type="submit" name="submit" value="Insert Details">
			</a>
	</form>
	
</body>
</html>