<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Task, java.util.ArrayList" %>
<%
ArrayList<Task> taskList = (ArrayList<Task>) session.getAttribute("taskList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% for(Task task: taskList){ %>
<form method="post" action="/TaskManagement/EditTask">
<input type="hidden" name="name" value=<%= task.getName() %>>
<input type="hidden" name="timeLimit" value=<%= task.getTimeLimit() %>>
<p><%= task.getName()  %>:<%= task.getTimeLimit() %></p><input type="submit" value="編集">
</form>
<% } %>
</body>
</html>