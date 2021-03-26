<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Me</title>
</head>
<body style="margin:0; background:#181818; color: white;">
	<div style="position: relative;min-height: 100vh;">
	<div style="padding-bottom: 7rem; margin: 10px;">
	
	<h1>Contact Me</h1>
	<p>It's a simple matter to contact me unless your name is Greg. I don't like that name so I ignore it.</p>
	
	<form:form action="./contact" method="post" modelAttribute="message">
		<div>
			<label>Name: </label>
			<form:input path="name" />
			<form:errors path="name"/>
		</div>
		<div>
			<label>Message: </label>
			<form:input path="message" />
			<form:errors path="message" />
		</div>
		<div>
			<input type="submit" value="Send" />
		</div>
	</form:form>
	
	</div>
	
	<%@ include file="footer.html" %>
	</div>
</body>
</html>