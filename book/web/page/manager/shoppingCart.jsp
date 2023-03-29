<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>图书管理</title>
    <%--  静态包含 css样式，js代码  --%>
    <%@include file="../common/head.jsp"%>
<%--    <link rel="stylesheet" href="static/css/common-manage-style.css">--%>
<%--    <link rel="stylesheet" href="static/css/login-success-style.css">--%>
    <link rel="stylesheet" href="static/css/shoppingCert-style.css">
    <script type="text/javascript" src="static/js/jquery-3.5.1.js"></script>
    <script>
        $(function () {
            $(".books #delete").click(function () {
                if(window.confirm("是否要删除该商品？")==false){
                    return false;
                }
            });
        });
    </script>
</head>

<body>
<header>
    <div class="ico clearfix">
        <a href="">
            <img src="static/img/title.gif"
                 alt="书城">
        </a>
        <span class="title">
            购物车
        </span>
        <%@include file="../common/login-success-meau.jsp"%>
    </div>
</header>
<main class="clearfix">
    <div class="main-common w">
        <!-- <div class="title">欢迎管理员进入后台管理系统</div> -->
        <div class="book">
            <table>
                <thead>
                <tr>
                    <th>商品名称</th>
                    <th>数量</th>
                    <th>单价</th>
                    <th>金额</th>
                    <th>操作</th>
                </tr>
                </thead>
            </table>
            <div class="table">
                <div class="books">
                    <table>

                        <tbody>
                        <c:if test="${sessionScope.cart.itemTotal==0}">
                        <tr>
                            <td></td>
                            <td rowspan="3" style="color: #393838;font-size: 18px">当前购物车为空!</td>
                            <td></td>
                            <td><a style="color: red;font-size: 30px" href="">去选购！</a> </td>
                            <td></td>
                        </tr>
                        </c:if>
                        <c:if test="${sessionScope.cart.itemTotal!=0}">
                            <c:forEach items="${sessionScope.cart.items}" var="item">
                            <tr>
                                <td>${item.value.name}</td>
                                <td>${item.value.number}</td>
                                <td>${item.value.price}</td>
                                <td>${item.value.price*item.value.number}</td>
                                <td><a id="delete" href="client/clientServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
                            </tr>
                            </c:forEach>
                        </c:if>
                    </table>
                </div>
            </div>
            <div class="payment">
                <div id="count">
                    购物车中共有
                    <span>${sessionScope.cart.itemTotal==null?0:sessionScope.cart.itemTotal}</span>
                    件商品
                </div>
                <div class="totalPrice">
                    总金额
                    <span>${sessionScope.cart.totalPrice==null?0:sessionScope.cart.totalPrice}</span>
                    元
                </div>
                <a href="client/clientServlet?action=clearCart">清空购物车</a>
                <a id="payment" href="orderServlet?action=checkout">去结账</a>
            </div>
        </div>
    </div>
</main>
<%@include file="../common/footer.jsp"%>
</body>

</html>
