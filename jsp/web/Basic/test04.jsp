<%--
  Created by IntelliJ IDEA.
  servlet: LDQ
  Date: 2020/5/27
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>静态包含</title>
</head>
<body>
<h1>这是源</h1>
<p>静态包含</p>
<hr>
<%@include file="test04_1.jsp"%>
<hr>
<p>动态包含</p>
<jsp:include page="test04_1.jsp"></jsp:include>
</body>
</html>
