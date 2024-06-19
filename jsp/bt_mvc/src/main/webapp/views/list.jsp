<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/18/2024
  Time: 3:38 PM
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
<div class="container my-5">
    <div class="d-flex justify-content-between my-3">
        <a href="/books/list" class="text-decoration-none text-black "><h2 class="fw-bold fs-2">Trang sách</h2></a>
        <div class="d-flex">
            <form action="/books/search" class="d-flex">
                <input class="form-control form-control-sm" type="text" name="keyword"
                       placeholder="Tìm kiếm theo tên sản phẩm" value="${keyword}">
                <button class="btn btn-primary ms-3">Tìm</button>
            </form>
        </div>
        <a href="/books/create" class="btn btn-primary">Thêm sản phẩm mới</a>
    </div>
    <c:if test="${error != null}">
        <div class="alert alert-danger" role="alert">
                ${error}
        </div>
    </c:if>
    <c:if test="${noti != null}">
        <div class="alert alert-success" role="alert">
                ${noti}
        </div>
    </c:if>
    <div>
        <table class="table ">
            <tr>
                <th>Số thứ tự</th>
                <th>Tên sách</th>
                <th>Số trang</th>
                <th>Tác giả</th>
                <th>Phân loại</th>
                <th></th>
            </tr>
            <c:forEach var="book" items="${books}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${book.title}</td>
                    <td>${book.pageSize}</td>
                    <td>${book.author}</td>
                    <td>${book.category}</td>
                    <td>
                        <a href="/books/delete?id=${book.id}" class="btn btn-danger">Xóa</a>
                        <a href="/books/update?id=${book.id}" class="btn btn-primary">Sửa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
