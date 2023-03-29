<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>书城项目</title>
    <base href="http://localhost:8080/book/">
    <link rel="stylesheet" href="static/css/reset.css">
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/index-style.css">
    <link rel="stylesheet" href="static/css/page-nav-style.css">
    <script type="text/javascript" src="static/js/jquery-3.5.1.js"></script>
    <script>
        function skip(){
            var text=$(".paging-nav ul li input[type='text']").val();
            var pageTotal=$(".paging-nav ul li .pageNumber").text();
            if(Number.parseInt(text)>Number.parseInt(pageTotal)){
                text=pageTotal;
            }
            window.location.href="${requestScope.page.url}&pageNo="+text;
        };
        $(function () {
            $(".price-margin #query").click(function () {
                $(".price-margin form").submit();
            });

            if(Number.parseInt($(".paging-nav ul li input[type='text']").val())==1){
                var pre=$(".paging-nav ul li #pre");
                pre.css("color","gray");
                pre.click(function () {
                    return false;
                });
            };
            if(Number.parseInt($(".paging-nav ul li input[type='text']").val())==Number.parseInt($(".paging-nav ul .pageNumber").text())){
                var next=$(".paging-nav ul li #next");
                next.css("color","gray");
                next.click(function () {
                    return false;
                });
            };
            $(".show-book .add input[type='button']").click(function () {
                // location.href="client/clientServlet?action=addItem";
                $(this).parent().submit();
            });
        })
    </script>
</head>

<body>
    <div class="all">
        <header class="clearfix">
            <div class="ico">
                <a href="">
                <img src="static/img/title.gif"
                    alt="书城">
                </a>
            </div>
            <div class="title">
                网上书城
            </div>
            <div class="nav">
                <ul>
<%--                    还没有登录，显示登录和注册--%>
                    <c:if test="${empty sessionScope.username}">
                        <li><a href="page/user/login.jsp">登录</a></li>
                        <li class="symbol">|</li>
                        <li><a href="page/user/register.jsp">注册</a></li>
                    </c:if>
                    <c:if test="${not empty sessionScope.username}">
                        <li><a href="orderServlet?action=order">我的订单</a></li>
                        <li class="symbol">|</li>
                        <li><a href="userServlet?action=logout">注销</a></li>
                    </c:if>
                    <li class="shopping"><a href="client/clientServlet?action=shoppingCart">购物车</a></li>
                    <li><a href="page/manager/manage.jsp">后台管理</a></li>
                </ul>
            </div>
        </header>
        <main class="clearfix">
            <div class="price-margin">
                <form action="userServlet">
                    <input type="hidden" name="action" value="pageForPrice">
                    价格:
                    <input type="text" name="begin" value="${requestScope.begin}"> 元 -
                    <input type="text" name="end" value="${requestScope.end}"> 元
                    <input id="query" type="button" value="查询">
                </form>
            </div>
            <div class="reminder">您的购物车中有<span class="itemTotal">${sessionScope.cart.itemTotal==null?0:sessionScope.cart.itemTotal}</span>件商品！</div>
            <div class="show-book">
                <ul class="clearfix">
                    <c:forEach items="${requestScope.page.dataList}" var="book">
                        <li>
                            <div class="cover">
                                <img src="${book.img_path}"
                                     alt="">
                            </div>
                            <div>书名：<span class="book-name">${book.name}</span></div>
                            <div>作者：<span class="book-writer">${book.author}</span></div>
                            <div>价格：<span class="price">${book.price}</span></div>
                            <div>销量：<span class="sales-volume">${book.sales}</span></div>
                            <div>库存：<span class="inventory">${book.stock}</span></div>
                            <div class="add">
                                <form action="client/clientServlet">
                                    <input type="hidden" name="action" value="addItem">
                                    <input type="hidden" name="id" value="${book.id}">
                                    <input type="button" value="加入购物车">
                                </form>
                            </div>
                        </li>
                    </c:forEach>

                </ul>
            </div>
            <%@include file="../common/page-nav.jsp"%>
        </main>
        <%@include file="../common/footer.jsp"%>
    </div>
</body>

</html>