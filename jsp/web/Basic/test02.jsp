<%--
  Created by IntelliJ IDEA.
  servlet: LDQ
  Date: 2020/5/27
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>四大域对象</title>
</head>
<body>
<%
    pageContext.setAttribute("key","pageContext");//当前页面有效
    request.setAttribute("key","request");//一次请求内有效
    session.setAttribute("key","session");//一次会话范围内有效
    application.setAttribute("key", "application");//一个工程范围内有效
%>
    pageContext的值:<%=pageContext.getAttribute("key")%><br>
    request的值:<%=request.getAttribute("key")%><br>
    session的值:<%=session.getAttribute("key")%><br>
    application的值:<%=application.getAttribute("key")%><br>
<%--请求转发--%>
<%
    request.getRequestDispatcher("/test/test02_1.jsp").forward(request,response);
%>
</body>
</html>
