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
<h1 style="color:green;">${sessionScope.tutorial.message}</h1>
<h1>Hii Admin: ${sessionScope.user.validatedUser.name}</h1>
<h2><a href="add_New_Tutorial.jsp">Add New Tutorial</a></h2>
<h2><a href="logout.jsp">LogOut</a></h2>
</body>
</html>