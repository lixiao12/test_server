<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/8
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/add.do" method="post">
    <input type="text" name="pname"><br>
    <input type="text" name="pid"><br>
    <input type="text" name="page"><br>
    <input type="submit" value="提交"><br>
</form><br>
<a href="/deploy.do">部署</a>
</body>
</html>
