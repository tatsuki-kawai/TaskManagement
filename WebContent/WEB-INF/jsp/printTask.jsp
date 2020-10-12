<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Task, java.util.ArrayList"%>
<%
	User user = (User) session.getAttribute("user");
ArrayList<Task> taskList = (ArrayList<Task>) session.getAttribute("taskList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="css/style.css" rel="stylesheet">
</head>
<body id="printTask">
	<div id="wrap">
		<div class="menubar clearfix">
			<div class="title">
				<form method="post" action="/TaskManagement/Login">
					<input type="hidden" name="name" value=<%=user.getName()%>>
					<input type="hidden" name="pass" value=<%=user.getPass()%>>
					<input id="titleImage" type="image" src="image/title.png"
						alt="たすマネ" width="200px" height="200px">
				</form>
			</div>
			<div class="menu">
				<div class="GoHome">
					<img src="image/homeIcon.png">
					<form id="form" method="post" action="/TaskManagement/Login">
						<input type="hidden" name="name" value=<%=user.getName()%>>
						<input type="hidden" name="pass" value=<%=user.getPass()%>>
						<input id="homeButton" type="submit" value="ホーム">
					</form>
				</div>
				<div class="AddTask">
					<img src="image/addIcon.png"> <a class="clearfix"
						href="/TaskManagement/CreateTask">新規登録</a>
				</div>
				<div class="PrintTaskList">
					<img src="image/listIcon.png"> <a class="clearfix"
						href="/TaskManagement/PrintTask">目標一覧</a>
				</div>
			</div>
		</div>
		<div class="main-content">
			<div class="title">
				<h1>目標一覧</h1>
			</div>
			<div class="taskList">
				<%
					for (Task task : taskList) {
				%>
				<div class="task">
					<div class="button clearfix">
						<form class="edit" method="post" action="/TaskManagement/EditTask">
							<input type="hidden" name="name" value=<%=task.getName()%>>
							<input type="hidden" name="timeLimit"
								value=<%=task.getTimeLimit()%>> <input id="editButton"
								type="image" src="image/editIcon.png" alt="編集" width="35px"
								height="25px">
						</form>
						<form class="delete" method="post" action="/TaskManagement/DeleteTask">
							<input type="hidden" name="name" value=<%=task.getName()%>>
							<input type="hidden" name="timeLimit"
								value=<%=task.getTimeLimit()%>> <input
								id="deleteButton" type="image" src="image/deleteIcon.png"
								alt="削除" width="35px" height="25px">
						</form>
						</div>
						<h2><%=task.getName()%></h2>
						<p><%=task.getTimeLimit()%>まで
						</p>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</body>
</html>