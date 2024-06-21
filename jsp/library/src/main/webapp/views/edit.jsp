<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/21/2024
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-body-tertiary">
<div class="mx-auto py-5 w-25 mt-5">
    <div>
        <h2 class="text-center text-decoration-none text-secondary mb-0">TRANG SỬA SÁCH</h2>
    </div>
    <div class="shadow-sm bg-white p-3 mt-3 rounded">
        <form action="/books/update" method="post">
            <div>
                <input type="hidden" name="id" id="id" value="${book.id}">
            </div>
            <div>
                <label class="form-label" for="title">Title</label>
                <input type="text" class="form-control" id="title" name="title" value="${book.title}">
            </div>
            <div>
                <label class="form-label" for="page_size">Số trang</label>
                <input type="text" class="form-control" id="page_size" name="page_size" value="${book.pageSize}">
            </div>
            <label class="form-label">Tác giả</label>
            <select class="form-select form-select mb-3" name="author_id">
                <c:forEach var="item" items="${authors}">
                    <option ${book.authorId == item.id ? "selected" : ""}
                            value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>
            <label class="form-label">Phân loại</label>
            <select class="form-select form-select mb-3" name="category_id">
                <c:forEach var="item" items="${categories}">
                    <option ${book.categoryId == item.id ? "selected" : ""}
                            value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>
            <a href="/books/list" class="btn btn-outline-secondary">Hủy</a>
            <button class="btn btn-success">Lưu</button>
        </form>
    </div>
</div>
</body>
</html>
