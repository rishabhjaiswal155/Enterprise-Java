<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test1</title>
</head>
<body>
<h1>From test1 page....</h1>
<% session.setAttribute("user_dtls", request.getParameter("em")+":"+request.getParameter("pass"));
response.sendRedirect("display2.jsp");%>
</body>
</html>