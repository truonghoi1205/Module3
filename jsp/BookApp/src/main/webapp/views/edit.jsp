<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 5/30/2024
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Edit Book</h1>
<form action="/books?action=update&id=${book.id}" method="post">
    <input name="name" value="${book.name}" placeholder="Enter name" >
    <input name="price" value="${book.price}" placeholder="Enter price" >
    <input name="description" value="${book.description}" placeholder="Enter description">
    <input name="author" value="${book.author}" placeholder="Enter author" >
    <div>
        <input type="submit" name="submit" value="Cập nhật"/>
    </div>
</form>
</body>
</html>
