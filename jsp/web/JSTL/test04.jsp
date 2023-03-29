<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  servlet: LDQ
  Date: 2020/5/27
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>遍历</title>
</head>
<body>
<c:forEach begin="1" end="20" var="i">
    ${i}
</c:forEach>
<br>
<hr>
<%
    request.setAttribute("arr",new String[]{"000","111","222","333","444","555","666","777","888","999"});
%>
<c:forEach items="${arr}" var="i">
    ${i}<br>
</c:forEach>
</body>
</html>
