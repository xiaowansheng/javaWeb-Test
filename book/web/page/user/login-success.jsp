<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录成功</title>
    <base href="http://localhost:8080/book/">
    <%--  静态包含 css样式，js代码  --%>
    <%@include file="../common/head.jsp"%>
    <link rel="stylesheet" href="static/css/login-success-style.css">
</head>

<body>
    <header>
        <div class="ico">
            <a href="">
                <img src="static/img/title.gif"
                     alt="书城">
            </a>
            <%-- 静态包含登录成功后的菜单   --%>
            <%@ include file="../common/login-success-meau.jsp"%>
        </div>
    </header>
    <main class="clearfix">
        <div class="main-common w">
            <div class="title">登录成功！<a href="client/clientServlet?action=page">转到主页</a>。</div>
        </div>
    </main>
    <%@include file="../common/footer.jsp"%>

</html>