<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/TaskManagement/CreateTask">
<p>タスク名</p>
<input type="text" name="task_name">
<p>期限</p>
<input type="date" name="task_limit" value="日にちを指定してください">
<input type="submit" value="作成">
</form>
</body>
</html>