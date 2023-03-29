<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>图书管理</title>
    <%--  静态包含 css样式，js代码  --%>
    <%@include file="../../common/head.jsp"%>
    <link rel="stylesheet" href="static/css/common-manage-style.css">
    <link rel="stylesheet" href="static/css/book-manage-style.css">
    <script>
        $(function () {
            $("table .delete").click(function () {
                if(window.confirm("是否确认删除【"+$(this).parent().parent().find("td:first-of-type").text()+"】？")==false){
                    return false;
                }
            });
        });
    </script>
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
                    <li><a href="javaScript:;">图书管理</a></li>
                    <li><a href="orderServlet?action=order">订单管理</a></li>
                    <li><a href="index.jsp">返回商城</a></li>
                </ul>
            </div>
        </div>
    </header>
    <main class="clearfix">
        <div class="main-common w">
            <!-- <div class="title">欢迎管理员进入后台管理系统</div> -->
            <div class="book">
                <table>
                    <thead>
                        <tr>
                            <th>名称</th>
                            <th>价格</th>
                            <th>作者</th>
                            <th>销量</th>
                            <th>库存</th>
                            <th class="twoTh" colspan="2">操作</th>
                        </tr>
                    </thead>
                </table>
                <div class="books">
                <table>
                    <tbody>
                            <c:forEach items="${requestScope.books}" var="book">
                                <tr>
                                    <td>${book.name}</td>
                                    <td>${book.author}</td>
                                    <td>${book.price}</td>
                                    <td>${book.sales}</td>
                                    <td>${book.stock}</td>
                                    <td><a href="manager/bookServlet?action=getBook&operate=update&id=${book.id}">修改</a></td>
                                    <td><a class="delete" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>
                                </tr>
                            </c:forEach>
                    </tbody>
                </table>
                </div>
                <table>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><a href="page/manager/book/book-edit.jsp?operate=add">添加图书</a></td>
                        </tr>
                </table>
            </div>
        </div>
    </main>
    <%@include file="../../common/footer.jsp"%>
</body>

</html>