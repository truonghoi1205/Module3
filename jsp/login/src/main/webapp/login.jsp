<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body class="bg-body-tertiary">
<div class="container mt-5">
    <div class="w-25 mt-3 bg-white shadow-sm rounded p-4 mx-auto">
        <h2 class="mb-4">Login</h2>

        <form action="/login" method="post">
            <c:if test="${errorMessage != null}">
            <div class="alert alert-danger my-2">${errorMessage}</div>
            </c:if>
            <div class="mb-3">
                <label class="form-label">Username</label>
                <input type="text" placeholder="input username" name="username" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="password" placeholder="input password" name="password" class="form-control">
            </div>
            <button class="btn btn-secondary mt-2">Đăng nhập</button>
        </form>
    </div>

</div>


</body>
</html>
