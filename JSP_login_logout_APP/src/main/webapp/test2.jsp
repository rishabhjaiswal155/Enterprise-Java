<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test2</title>
</head>
<%! String msg="Hii Rishabh";%>
<body>
<h1>from test1 page...</h1>
<% int counter=100;
pageContext.setAttribute("nm", 1234);
%>
<h1>test1 page ends here...</h1>
<%@ include file="test3.jsp"%>
</body>
</html>