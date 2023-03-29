<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>结算成功</title>
    <%--  静态包含 css样式，js代码  --%>
    <%@include file="../../common/head.jsp"%>
    <link rel="stylesheet" href="static/css/checkout-style.css">
</head>

<body>
    <header>
        <div class="ico">
            <img src="static/img/title.gif" alt="logo">
            <div class="nav">
                <ul>
                    <li>欢迎<span>憨憨</span>光临网上书城</li>
                    <li><a href="orderServlet?action=order">我的订单</a></li>
                    <li><a href="userServlet?action=logout">注销</a></li>
                    <li><a href="client/clientServlet?action=shoppingCart">返回</a></li>
                </ul>
            </div>
        </div>
    </header>
    <main class="clearfix">
        <div class="main-common w">
            <div class="title">您的订单【${sessionScope.orderId}】已结算成功！<a href="">转到主页</a>。</div>
        </div>
    </main>
    <%@include file="../../common/footer.jsp"%>
</body>

</html>