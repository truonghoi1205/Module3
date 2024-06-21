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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body class="bg-body-tertiary">
<div class="container py-5 w-75 ">
    <div class="d-flex justify-content-between p-3 shadow-sm bg-white mb-3 align-items-center rounded">
        <h2 class="text-decoration-none text-secondary mb-0">Trang sách</h2>
        <a href="/books/create" class="btn btn-sm btn-primary px-4">Thêm sách</a>
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
    <div class="shadow-sm bg-white p-2 rounded">
        <table class="table table-bordered table-hover text-center ">
            <thead>
            <tr>
                <th>STT</th>
                <th class="text-start">Tên sách</th>
                <th>Số trang sách</th>
                <th class="text-start">Tên tác giả</th>
                <th class="text-start">Phân loại</th>
                <th></th>
            </tr>
            </thead>
            <tbody class="table-group-divider">
            <c:forEach var="book" items="${books}" varStatus="status">
                <tr>
                    <th>${status.count}</th>
                    <td class="text-start">${book.title}</td>
                    <td>${book.pageSize}</td>
                    <td class="text-start">${book.author.name}</td>
                    <td class="text-start">${book.category.name}</td>
                    <td class="d-flex justify-content-center">
                        <div class="me-2">
                            <a class="btn btn-outline-danger btn-sm" data-bs-toggle="modal"
                               data-bs-target="#book-${book.id}">Xóa</a>
                            <div class="modal fade" tabindex="-1" id="book-${book.id}">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-body p-3">
                                            <h2 class="mb-3 text-center h4">Bạn có muốn xóa sách này không?</h2>
                                            <div class="text-center mt-1">
                                                <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">
                                                    Hủy
                                                </button>
                                                <a href="/books/delete?id=${book.id}"
                                                   class="btn btn-danger">Xóa</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div>
                            <a href="/books/update?id=${book.id}" class="btn btn-outline-primary btn-sm">Sửa</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
