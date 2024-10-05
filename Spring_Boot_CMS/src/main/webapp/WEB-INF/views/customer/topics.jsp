<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topics</title>
</head>
<body>
<h1 style="color:green">${requestScope.msg}</h1>
<h3>Valid User Details under role:${sessionScope.user_dtls.roles}</h3>
<spring:url  var="url" value="/customer/tutorials"/>
<form action="${url}">
<h1>Topics List</h1>
<c:forEach var="t" items="${requestScope.topic_dtls}">
<h2><input type="radio" name="topicId" value="${t.id}">${t.topicName}</h2>
</c:forEach>
<h2><input type="submit" value="Choose a Topic"/></h2>
</form>
</body>
</html>