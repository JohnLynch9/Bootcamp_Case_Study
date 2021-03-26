<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body style="margin:10px; background:#181818;">
	<h1>Register Page</h1>
	<form:form action="./register" method="post" modelAttribute="user">
		<div>
			<label>Name: </label>
			<form:input path="name" />
			<form:errors path="name"/>
		</div>
		<div>
			<label>Email: </label>
			<form:input path="email" />
			<form:errors path="email" />
		</div>
		<div>
			<label>Password: </label>
			<form:input path="password" />
			<form:errors path="password" />
		</div>
		<div>
			<input type="submit" value="Register" />
		</div>
	</form:form>
	<div>
	<p>Already have an account?</p>
	<a href="./login" style="color: blue">Login</a>
	</div>
</body>
</html>