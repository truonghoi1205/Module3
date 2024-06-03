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
<h1> Create Book</h1>
<form action="/books?action=create" method="post">
    <input name="name" placeholder="Enter name">
    <input name="price" placeholder="Enter price">
    <input name="description" placeholder="Enter description">
    <input name="author" placeholder="Enter author">
    <button>Save</button>
</form>
</body>
</html>
