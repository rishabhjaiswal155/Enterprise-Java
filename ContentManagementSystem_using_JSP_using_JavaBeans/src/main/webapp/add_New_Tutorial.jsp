<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add_New_Tutorial</title>
</head>
<body>
<h1 style="color:red;">${sessionScope.tutorial.message}</h1>
<form action="process_form.jsp" method="post">
      <table style="background-color: lightgrey; margin: auto">
        <caption>Add New Tutorial</caption>
        <tr>
          <td>Topic</td>
          <td><select name="topicId">
          <c:forEach var="t" items="${sessionScope.topic.getAllTopics()}">
          <option value="${t.topicId}">${t.topicName}</option>
          </c:forEach>
          </select></td>
        </tr>
        <tr>
          <td>Name</td>
          <td><input type="text" name="tutorialName" /></td>
        </tr>
        <tr>
          <td>Author</td>
          <td><input type="text" name="author" /></td>
        </tr>
        <tr>
          <td>Published Date</td>
          <td><input type="date" name="pubDate" /></td>
        </tr>
        <tr>
          <td>contents</td>
          <td><textarea rows="10"  cols="40" name="contents" ></textarea></td>
        </tr>
        <tr>
          <td><input type="submit" value="Add Tutorial" /></td>
        </tr>
      </table>
    </form>
</body>
</html>