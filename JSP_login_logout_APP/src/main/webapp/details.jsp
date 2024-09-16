<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
</head>
<body>
<h1 align="center">JSession ID:${pageContext.session.id}</h1> 
<h1>valid UserDetails:
${sessionScope.user_dtls}
<%String url=response.encodeURL("logout.jsp");%>
<br/><a href="<%=url%>">LogOut</a></h1>
</body>
</html>