<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  servlet: LDQ
  Date: 2020/5/27
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多重条件判断</title>
</head>
<body>
<%
    request.setAttribute("grade",88);
%>
<c:choose>
    <c:when test="${grade>=100}"><h1>满分</h1></c:when>
    <c:when test="${grade>=90}"><h1>优秀</h1></c:when>
    <c:when test="${grade>=75}"><h1>良好</h1></c:when>
    <c:when test="${grade>=60}"><h1>及格</h1></c:when>
    <c:otherwise><h1>不及格</h1></c:otherwise>
</c:choose>
</body>
</html>
