<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  servlet: LDQ
  Date: 2020/5/27
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>if判断</title>
</head>
<body>
<c:if test="${1==1}">
    <%--结果为true则执行中间代码--%>
    <h1>条件成立</h1>
</c:if>
</body>
</html>
