<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>后台管理</title>
    <%--  静态包含 css样式，js代码  --%>
    <%@include file="../common/head.jsp"%>
    <link rel="stylesheet" href="static/css/common-manage-style.css">
    <link rel="stylesheet" href="static/css/manage-style.css">
</head>

<body>
    <header>
        <div class="ico clearfix">
            <div class="img">
                <a href="">
                    <img src="static/img/title.gif"
                         alt="书城">
                </a>
            </div>
            <div class="title">
                后台管理系统
            </div>
            <div class="nav">
                <ul>
                    <li><a href="manager/bookServlet?action=queryList">图书管理</a></li>
                    <li><a href="orderServlet?action=order">订单管理</a></li>
                    <li><a href="">返回商城</a></li>
                </ul>
            </div>
        </div>
    </header>
    <main class="clearfix">
        <div class="main-common w">
            <div class="title">欢迎管理员进入后台管理系统</div>
        </div>
    </main>
    <%@include file="../common/footer.jsp"%>
</body>

</html>