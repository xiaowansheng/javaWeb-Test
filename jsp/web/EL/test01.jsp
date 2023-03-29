<%--
  Created by IntelliJ IDEA.
  servlet: LDQ
  Date: 2020/5/27
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取四个域中的数据</title>
</head>
<body>
<%
    pageContext.setAttribute("key","pageContext");//当前页面有效
    request.setAttribute("key","request");//一次请求内有效
    session.setAttribute("key","session");//一次会话范围内有效
    application.setAttribute("key", "application");//一个工程范围内有效
%>
${key}<%--只有key值是按从小到大搜索值--%>
${pageScope.get("key")}<br>
${requestScope.get("key")}<br>
${sessionScope.key}<br>
...
</body>
</html>
