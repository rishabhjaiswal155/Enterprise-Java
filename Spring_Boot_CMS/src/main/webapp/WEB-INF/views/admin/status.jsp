<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>status</title>
</head>
<body>
<h1>In admin status Page....</h1>
<h1>${requestScope.msg}</h1>
<h1>Valid User Details under role:${requestScope.user_dtls.roles.roleName}</h1>
</body>
</html>