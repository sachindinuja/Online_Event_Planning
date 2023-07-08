<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="login.css">
<title>Insert title here</title>
</head>
<body>

	 <nav class="header">
       <h1>Online <span>Event Planning</span> System</h1>
       <ul>
          <li><a class="active" href="home.jsp">Home</a></li>
          <li><a href="event.jsp">Event</a></li>
          <li><a href="contactusinsert.jsp">ContactUs</a></li>
          <li><a href="#">login</a></li>
        </ul>
    </nav>

	<form action="log" method="post">
		User Name <input type="text" name="uid"><br>
		Password <input type="password" name="pass"><br>
		
		<input type="submit" name="submit" value="login">
	</form>

</body>
</html>