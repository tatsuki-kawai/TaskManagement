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
<body id="createTask">
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
            <form class="form" method="post" action="/TaskManagement/CreateTask">
                <h1>新規目標の作成</h1>
                <div class="task-parameter">
                    <p class="name">目標名:</p>
                    <input class="task-name" type="text" name="task_name">
                </div>
                <div class="task-parameter">
                    <p class="date">期限:</p>
                    <input class="task-date" type="date" name="task_limit" value="日にちを指定してください">
                </div>
                <div class="task-parameter">
                    <p class="memo">メモ</p>
                    <textarea class="task-memo" rows="4" cols="40"></textarea>
                    <br>
                </div>
                <div class="submit">
                    <input class="task-submit" type="submit" value="作成">
                </div>
            </form>
        </div>
    </div>
</body>
</html>