<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display</title>
</head>
<body>
<h1 align="center">SessionID=<%=session.getId() %></h1>
<h2>Testing Implicit Objects using Scriplets</h2>
<h2>Userdetails using Scriplets</h2>
<h3>JspWritter:
<% out.print("Hello");
%>
</h3>
<h3>Your Email:
<%
out.print(request.getParameter("em"));%>
</h3>
<h3>Your Password:
<%out.print(request.getParameter("pass")); %></h3>
<hr/>
<h2>Testing Implicit Objects using JSP Expression</h2>
<h2>Userdetails using JSP Expressions</h2>
<h3>Your Email:
<%=request.getParameter("em")%>
</h3>
<h3>Your Password:
<%=request.getParameter("pass")%>
</h3>
</body>
</html>