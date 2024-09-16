<%@page import="pojos.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validate</title>
</head>
<%!
HashMap<String,User> users;
public void jspInit(){
	users=new HashMap<>();
	users.put("Rishabh",new User("Rishabh","Rishi",28));
	users.put("Lucky",new User("Lucky","luci",26));
}
%>
<body>
<%
String name=request.getParameter("nm");
String pass=request.getParameter("pass");
User user=users.get(name);
if(user!=null){
	if(user.getPassword().equals(pass)){
		session.setAttribute("user_dtls", user);
		response.sendRedirect(response.encodeRedirectURL("details.jsp"));
	}
	else{
		%>
		<h1>Invalid login details...Please <a href="login.jsp">Try again</a></h1>
	<%
	}
}else{
	%>
	<h1>User is not Registered!!Please<a href="register.jsp">Register</a></h1>
<%
}
%>
</body>
</html>