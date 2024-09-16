<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
<h1 align="center">JSession ID:${pageContext.session.id}</h1> 
<h1>Hii ${sessionScope.user_dtls.name}</h1>
<%session.invalidate();%>
<h1>You are Successfully logout from App</h1>
<h1><a href="login.jsp">Visit us Again...</a></h1>
</body>
</html>