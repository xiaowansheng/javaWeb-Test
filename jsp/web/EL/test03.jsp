<%--
  Created by IntelliJ IDEA.
  servlet: LDQ
  Date: 2020/5/27
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取请求参数</title>
</head>
<body>
${param}<br>
账号：${param.username}<br>
密码：${param.password}<br>
请求头部信息：${header}<br>
<hr>
获取请求头user-Agent信息:${header["user-Agent"]}<br>
获取请求头connection信息:${header.connection}<br>
获取cookie的名称${cookie.JSESSIONID.name}<br>
获取cookie的值${cookie.JSESSIONID.value}<br>

</body>
</html>
