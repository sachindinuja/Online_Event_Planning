<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="contact.css">
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
	
	<form action="input" method="post">
	<table>
	<tr>
			<td>Name<input type="text" name="name"   placeholder="Full name.."><br></td>
	</tr>	
	<tr>
	 		<td>Email <input type="text" name="email"  placeholder="Enter email here.."></td>
	</tr>
	<tr>
			<td>Phone No <input type="text" name="phone" placeholder="+94"></td>
	</tr>
	 
	<tr>
			<td>Subject <input type="text" name="subj" placeholder="type.."></td>
	</tr>
	
	<tr>
			<td>User ID <input type="text" name="uname" placeholder="Enter user ID"></td>
	</tr>
	
	<tr>
			<td>	Create Password <input type="password" name="pass" placeholder="5-digits"></td>
	</tr>
	<br>
	
	</table>
	<br><br>
	<input type="submit" name="submit"  value="Submit">
	</form>
	
<div class="footer">
		<a href="#" class="fa fa-facebook"></a>
		<a href="#" class="fa fa-twitter"></a>
		<a href="#" class="fa fa-linkedin"></a>
		<a href="#" class="fa fa-pinterest"></a>
</div>
	
</body>
</html>