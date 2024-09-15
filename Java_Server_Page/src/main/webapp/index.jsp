<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
</head>
<body>
<h1>Welcome to JSP...@<%=LocalDateTime.now() %></h1>
<h2><a href="comments.jsp">Testing Comments</a></h2>
<h2><a href="login.jsp">Testing Scripting Elements</a></h2>
</body>
</html>