<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/29/2024
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Quản lý sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header d-flex justify-content-between">
            <h2>Quản Lý Sách</h2>
            <a href="/books/new" class="btn btn-primary ">Thêm</a>
        </div>
        <div class="card-body">
            <table class="table table-hover text-center  ">
                <thead>
                <tr>
                    <th scope="col">Số thứ tự</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Mô tả</th>
                    <th scope="col">Tác giả</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${books}" var="book" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${book.name}</td>
                        <td>${book.price}</td>
                        <td>${book.description}</td>
                        <td>${book.auth}</td>
                        <td>
                            <a href="/books/update?id=${book.id}" class="btn btn-success btn-sm">Sửa</a>
                            <a href="/books/delete?id=${book.id}" class="btn btn-danger btn-sm">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
