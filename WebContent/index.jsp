<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TaskManagement ログイン</title>
</head>

<body>
<form action="/TaskManagement/Login" method="post">
<p>名前</p>
<input type="text" name="name"><br>
<p>パスワード</p>
<input type="password" name="pass"><br>
<input type="submit" value="ログイン"><br>
</form>
</body>
</html>