<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/31/2024
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users?action=edit&id=${user.id}" method="post">
    <input name="name" value="${user.name}" placeholder="Enter name" >
    <input name="email" value="${user.email}" placeholder="Enter email" >
    <input name="country" value="${user.country}" placeholder="Enter country">
    <div>
        <input type="submit" name="submit" value="cập nhật">
    </div>

</form>
</body>
</html>
