<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>我的订单</title>
    <%--  静态包含 css样式，js代码  --%>
    <%@include file="../../common/head.jsp"%>
    <link rel="stylesheet" href="static/css/order-style.css">
</head>

<body>
<header>
    <div class="ico">
        <img src="static/img/title.gif" alt="logo">
        <span class="title">我的订单</span>
        <div class="nav">
            <ul>
                <li>欢迎<span>憨憨</span>光临网上书城</li>
                <li><a href="javaScript:;">我的订单</a></li>
                <li><a href="userServlet?action=logout">注销</a></li>
                <li><a href="">返回</a></li>
            </ul>
        </div>
    </div>
</header>
<main class="clearfix">
    <div class="main-common w">
        <div class="order">
            <table>
                <thead>
                <tr>
                    <th>订单号</th>
                    <th>日期</th>
                    <th>金额</th>
                    <th>状态</th>
                    <th>详情</th>
                </tr>
                </thead>
            </table>
            <div class="orders">
                <table>
                    <tbody>
                    <c:forEach items="${requestScope.orders}" var="order">
                        <tr>
                            <td>${order.orderId}</td>
                            <td>${order.createTime}</td>
                            <td>${order.price}</td>
                            <td>${order.status}</td>
                            <td><a href="#">查看详情</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</main>
<%@include file="../../common/footer.jsp"%>
</body>

</html>