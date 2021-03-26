<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body style="margin:0; background:#181818; color: white;">
	<div style="position: relative;min-height: 100vh;">
	<div style="padding-bottom: 7rem; margin: 10px;">
	
	<h1>Welcome ${loguser}</h1>
	
	
	<p>Today is <%=new Date()%></p>
	</div>
	
	<%@ include file="footer.html" %>
	</div>
</body>
</html>