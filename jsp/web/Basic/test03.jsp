<%--
  Created by IntelliJ IDEA.
  servlet: LDQ
  Date: 2020/5/27
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out和getWrite输出</title>
</head>
<body>
<%
    out.write("1、这是out-1<br>");
    response.getWriter().write("2、这是getWrite-1<br>");
    response.getWriter().write("3、这是getWrite-2<br>");
    out.write("4、这是out-2<br>");
%>
<%--输出时，out的数据会加在reponse的数据后面输出--%>
</body>
</html>
