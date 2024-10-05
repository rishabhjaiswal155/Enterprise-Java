<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
   <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tutorials</title>
</head>
<body>
<h1>Hello:${sessionScope.user_dtls.firstName}</h1>
<h1>Tutorial Title under topicId ${param.topicId}</h1>
<c:forEach var="t" items="${requestScope.tut_names}">
<h2><a href="<spring:url value='/customer/tutorialDetails?tutorialTitle=${t}'/>">${t}</a></h2>
</c:forEach>
</body>
</html>