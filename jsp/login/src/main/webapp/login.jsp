<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/24/2024
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <h2>Login</h2>
    <input type="text" placeholder="input username" name="username">
    <input type="password" placeholder="input password" name="password">
    <button>Đăng nhập</button>
</form>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
        out.println("<p style='color:red;'>" + errorMessage + "</p>");
    }
%>
</body>
</html>
