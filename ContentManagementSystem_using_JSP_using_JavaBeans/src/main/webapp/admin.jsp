<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
<h1>${sessionScope.user.message}</h1>
<h1>Hii Admin: ${sessionScope.user.validatedUser.name}</h1> 
</body>
</html>