<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
    <form action="http://localhost:8080/cookie_session/login" method="post">
        账号<input type="text" name="username" value="${cookie.username.value}"><br>
        密码<input type="text" name="password"><br>
        <input type="submit">
    </form>
</body>
</html>