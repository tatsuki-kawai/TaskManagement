<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="./css/style.css" rel="stylesheet">
    </head>
    <body id="Login">
        <div id ="wrap">
            <div class="content">
                <div id="main-content">
                    <div class="introduction">
                        <h1>たすマネへようこそ！</h1>
                        <p>たすマネでは目標の設定や管理を行うことができます。</p>
                    </div>
                    <div class="title">
                        <img src="image/title.png">
                    </div>
                    <form id="form" action="/TaskManagement/Login" method="post">
                        <div id="inputDate">
                            <h1>ログイン</h1>
                            <p>名前</p>
                            <input type="text" name="name">
                            <p>パスワード</p>
                            <input type="password" name="pass"><br>
                            <input id="LoginButton" type="submit" value="ログイン">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>