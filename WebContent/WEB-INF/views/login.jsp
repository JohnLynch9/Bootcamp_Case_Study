<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body style="margin:10px; background:#181818;">
	<h1>Login Page</h1>
	<form action="./login" method="post">
		<!--  <div>
			<label>Name</label>
			<input type="text" name="name" />
		</div> -->
		<div>
			<label>Email</label>
			<input type="text" name="email" />
		</div>
		<div>
			<label>Password</label>
			<input type="text" name="password" />
		</div>
		<div>
			<input type="submit" value="Login" />
		</div>
	</form>
	<div>
	<p>Need an account?</p>
	<a href="./register" style="color: blue">Register New Account</a>
	</div>
</body>
</html>