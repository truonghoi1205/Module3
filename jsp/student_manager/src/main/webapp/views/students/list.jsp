<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/3/2024
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<table class="table text-center">
    <h2 class="text-center">List of Student</h2>
    <tr>
        <th>Stt</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Lớp</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="student" items="${students}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.classroom.name}</td>
            <td>
                <a href="/students/edit?id=${student.id}">Edit</a>
                <a href="/students/delete?id=${student.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
