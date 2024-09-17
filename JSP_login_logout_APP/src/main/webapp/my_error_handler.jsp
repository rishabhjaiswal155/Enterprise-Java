<%@ page language="java"  isErrorPage="true"   contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1 style="color:red;">Error Message: ${pageContext.exception.message}</h1> 
<h1 style="color:red;">Exception: ${pageContext.exception}</h1>
<h1 style="color:red;">Error code: ${pageContext.errorData.statusCode}</h1>
<h1 style="color:red;">Page causing Error: ${pageContext.errorData.requestURI}</h1>
</body>
</html>