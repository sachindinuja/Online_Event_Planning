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
	<table>
	<c:forEach var="cont" items="${contDetails}">
	
	
	<c:set var="id" value="${cont.id}"/>
	<c:set var="name" value="${cont.name}"/>
	<c:set var="email" value="${cont.email}"/>
	<c:set var="phone" value="${cont.phone}"/>
	<c:set var="subject" value="${cont.subject}"/>
	<c:set var="username" value="${cont.userName}"/>
	<c:set var="password" value="${cont.password}"/>

	
	<tr>
		<td>Contact ID</td>
		<td>${cont.id}</td>
	</tr>
	<tr>
		<td>Contact Name</td>
		<td>${cont.name}</td>
	</tr>
	<tr>
		<td>Contact Email</td>
		<td>${cont.email}</td>
	</tr>
	<tr>
		<td>Contact Phone</td>
		<td>${cont.phone}</td>
	</tr>
	<tr>
		<td>Subject</td>
		<td>${cont.subject}</td>
	</tr>
	
	<tr>
		<td>User Name</td>
		<td>${cont.userName}</td>
	</tr>
	
	<tr>
		<td>Password</td>
		<td>${cont.password}</td>
	</tr>

	</c:forEach>
	</table>
	
		<c:url value="updatecontact.jsp" var="contupdate">
			<c:param name="id" value="${id}"/>
			<c:param name="name" value="${name}"/>
			<c:param name="email" value="${email}"/>
			<c:param name="phone" value="${phone}"/>
			<c:param name="subj" value="${subject}"/>
			<c:param name="uname" value="${username}"/>
			<c:param name="pass" value="${password}"/>

		</c:url>
	
	<a href="${contupdate}">
	<br>
	<input type="button" name="update" value="Edit Form">
	</a>
	
		<c:url value="deletecontact.jsp" var="contdelete">
			<c:param name="id" value="${id}"/>
			<c:param name="name" value="${name}"/>
			<c:param name="email" value="${email}"/>
			<c:param name="phone" value="${phone}"/>
			<c:param name="subj" value="${subject}"/>
			<c:param name="uname" value="${username}"/>
			<c:param name="pass" value="${password}"/>

		</c:url>
	
	<a href="${contdelete}">
	<br>
	<input type="button" name="delete" value="Delete Form">
	</a>
</body>
</html>