<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Task" %>
<%
Task task = (Task) session.getAttribute("task");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/TaskManagement/ReflectTask">
<input type="text" name="name">
<input type="date" name="timeLimit" value=<%= task.getTimeLimit() %>>
<input type="submit" value="変更">
</form>
</body>
</html>