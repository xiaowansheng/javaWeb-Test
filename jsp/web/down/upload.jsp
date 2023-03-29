<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件下载</title>
</head>
<body>
<form method="post" action="http://localhost:8080/jsp/upload" enctype="multipart/form-data">
    账号:<input type="text" name="username"><br>
    照片:<input type="file" name="photo"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
