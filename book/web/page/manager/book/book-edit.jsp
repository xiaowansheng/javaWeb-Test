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
    <link rel="stylesheet" href="static/css/book-edit-style.css">
    <script>
        $(function () {
            $("table input[type='submit']").click(function () {
                var text=$("table input[type='text']");
                console.log(text);
                for(var i=0;i<text.length;i++){
                    if(text.eq(i).val()==null||text.eq(i).val()==""){
                        // alert("书籍信息不允许有空值。");
                        return false;
                    }
                }
                // alert("没有空值。");
            });
        })
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
            编辑书籍
        </div>
        <div class="nav">
            <ul>
                <li><a href="manager/bookServlet?action=queryList">图书管理</a></li>
                <li><a href="orderServlet?action=order">订单管理</a></li>
                <li><a href="index.jsp">返回商城</a></li>
            </ul>
        </div>
    </div>
</header>
<main class="clearfix">
    <div class="main-common w">
        <div class="book">
            <form action="manager/bookServlet">
                <input type="hidden" name="action" value="${param.operate}">
                <input type="hidden" name="id" value="${requestScope.book.id}">
                <table>
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>作者</th>
                        <th>价格</th>
                        <th>销量</th>
                        <th>库存</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input type="text" name="name" value="${requestScope.book.name}"></td>
                        <td><input type="text" name="author" value="${requestScope.book.author}"></td>
                        <td><input type="text" name="price" value="${requestScope.book.price}"></td>
                        <td><input type="text" name="sales" value="${requestScope.book.sales}"></td>
                        <td><input type="text" name="stock" value="${requestScope.book.stock}"></td>
                        <td><input type="submit"></td>
                    </tr>

                    </tbody>
                </table>
            </form>

        </div>
    </div>
</main>
<%@include file="../../common/footer.jsp"%>
</body>

</html>