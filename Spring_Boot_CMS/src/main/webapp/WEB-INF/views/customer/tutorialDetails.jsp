<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tutorial Details</title>
</head>
<body>
<h1>Hello ${sessionScope.user_dtls.firstName}</h1>
<h1>Tutorial Details:</h1><br/>
<h2>${requestScope.tut_dtls}</h2>
<c:set var="topic" value="${requestScope.tut_dtls.author}"/>
<h2>Authored by:${topic.firstName}&nbsp;${topic.lastName}</h2>
<h3><a href="<spring:url value='/customer/tutorials?topicId=${topic.id}'/>">Back</a></h3>
<h3><a href="<spring:url value='/user/logout'/>">Log Out</a></h3> 
</body>
</html>