<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
<h1>Hii ${sessionScope.user.validatedUser.name}</h1>
<h1>You are Successfully logOut!!!</h1>
${sessionScope.user.userdao.cleanUp()}
${sessionScope.topic.topicDao.cleanUp()}
${sessionScope.tutorial.tutDao.cleanUp()}
<% session.invalidate();%>
</body>
</html>