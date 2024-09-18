<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my_error_handler</title>
</head>
<body>
<h1 style="color:red;">Exception:${pageContext.exception.message}</h1>
<h1 style="color:red;">caused at:${pageContext.errorData.requestURI}</h1> 
</body>
</html>