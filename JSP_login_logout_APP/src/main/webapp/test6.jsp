<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test6</title>
</head>
<body>
<h1>from test6 page...</h1>
<%request.setAttribute("product_dtls",request.getParameter("product_id")+"@"+request.getParameter("price"));
//out.flush(); 
%>
<jsp:include page="test7.jsp">
<jsp:param value="oil" name="category"/>
</jsp:include>
<h1>contents after include action</h1>
</body>
</html>