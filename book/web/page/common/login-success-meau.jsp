<%--
  Created by IntelliJ IDEA.
  User: LDQ
  Date: 2020/8/15
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="nav">
    <ul>
        <li>欢迎<span>${sessionScope.username}</span>光临网上书城</li>
        <li><a href="orderServlet?action=order">我的订单</a></li>
        <li><a href="userServlet?action=logout">注销</a></li>
        <li><a href="index.jsp">返回</a></li>
    </ul>
</div>
