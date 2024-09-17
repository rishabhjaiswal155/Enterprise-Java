<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test4</title>
</head>
<body>
<h1>from test4 page...</h1>

<%request.setAttribute("product_dtls",request.getParameter("product_id")+"@"+request.getParameter("price"));
//out.flush(); 
%>
<jsp:forward page="test5.jsp">
<jsp:param value="oil" name="category"/>
</jsp:forward>
<h1>contents after forward action</h1>
</body>
</html>