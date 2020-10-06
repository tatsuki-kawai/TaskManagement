<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%
User user = (User)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="css/style.css" rel="stylesheet">
</head>
<body id="Main">
	<div id="wrap">
		<div class="menubar clearfix">
			<div class="title">
			    <form method="post" action="/TaskManagement/Login">
						<input type="hidden" name="name" value=<%= user.getName() %>>
						<input type="hidden" name="pass" value=<%= user.getPass() %>>
						<input id="titleImage" type="image" src="image/title.png" alt="たすマネ" width="200px" height="200px">
				</form>
			</div>
			<div class="menu">
				<div class="GoHome">
					<img src="image/homeIcon.png">
					<form id="form" method="post" action="/TaskManagement/Login">
						<input type="hidden" name="name" value=<%= user.getName() %>>
						<input type="hidden" name="pass" value=<%= user.getPass() %>>
						<input id="homeButton" type="submit" value="ホーム">
					</form>
				</div>
				<div class="AddTask">
					<img src="image/addIcon.png">
					<a class="clearfix" href="/TaskManagement/CreateTask">新規登録</a>
				</div>
				<div class="PrintTaskList">
					<img src="image/listIcon.png">
					<a class="clearfix" href="/TaskManagement/PrintTask">目標一覧</a>
				</div>
			</div>
		</div>
		<div class="main-content">
		    <div>
		        <h1>ようこそ！<%= user.getName() %>さん！<br>まずは目標を登録しましょう！</h1>
		    </div>
		</div>
	</div>
</body>
</html>