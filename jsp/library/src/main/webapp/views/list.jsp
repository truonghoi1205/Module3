<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/20/2024
  Time: 8:52 AM
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
<div class="container py-5">
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>STT</th>
                <th>Tên sách</th>
                <th>Số trang sách</th>
                <th>Tên tác giả</th>
                <th>Phân loại</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${books}" varStatus="status">
                <tr>
                    <th>${status.count}</th>
                    <td>${book.title}</td>
                    <td>${book.pageSize}</td>
                    <td>${book.author.name}</td>
                    <td>${book.category.name}</td>
                    <td>
                        <a href="#" class="btn btn-danger">Xóa</a>
                        <a href="#" class="btn btn-primary">Sửa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
