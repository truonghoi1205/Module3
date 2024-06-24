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
<h2>Login Success</h2>
<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
        out.println("<p style='color:green;'>" + message + "</p>");
    }
%>
</body>
</html>
