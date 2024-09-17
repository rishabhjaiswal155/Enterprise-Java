<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<h1 align="center">JSession ID:${pageContext.session.id}</h1> 
<h1>Welcome to DashBoardApp in JSP</h1>
<h2><a href="login.jsp">Sign In</a></h2>
<h2><a href="test1.jsp">Testing Centralized Error Handling</a></h2>
<h2><a href="test2.jsp">Testing JSP include Directive</a></h2>
<h2><a href="test4.jsp?product_id=101&price=5000">Testing JSP Forward Action</a></h2>
<h2><a href="test6.jsp?product_id=101&price=5000">Testing JSP include Action</a></h2>
</body>
</html>