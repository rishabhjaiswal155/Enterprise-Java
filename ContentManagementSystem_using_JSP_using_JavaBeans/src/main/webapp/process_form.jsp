<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Process-form</title>
</head>
<jsp:setProperty property="*" name="tutorial"/>
<body>
<c:redirect url="${sessionScope.tutorial.validateAndInsertTutorial()}.jsp"/>
</body>
</html>