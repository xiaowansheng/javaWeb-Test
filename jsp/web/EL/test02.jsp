<%--
  Created by IntelliJ IDEA.
  servlet: LDQ
  Date: 2020/5/27
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext对象</title>
</head>
<body>
<%--数据封装起来--%>
<%
    pageContext.setAttribute("req",request);
%>
<%=request.getScheme()%><br>
<%--通过pageContext获取jsp内置对象--%>
${pageContext.request.scheme}<br>
1、获取请求的协议
<%--Scheme对应着方法getScheme--%>
${req.scheme}<br>
2、获取请求的服务器ip或域名
${req.serverName}<br>
3、获取获取请求的服务器端口号
${req.serverPort}<br>
4、获取当前工程路径
${req.contextPath}<br>
5、获取请求的方式
${req.method}<br>
6、获取客户端的ip地址
${req.remoteHost}<br>
7、获取客户端的端口号
${req.remotePort}<br>
8、获取会话的唯一标识
${pageContext.session.id}<br>
</body>
</html>
