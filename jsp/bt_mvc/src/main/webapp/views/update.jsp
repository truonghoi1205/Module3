<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/19/2024
  Time: 9:52 AM
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
    <div class="row justify-content-center">
        <div class="col-12 col-lg-6">
            <h2 class="text-center my-3">Trang sửa sách</h2>
            <form action="/books/update" method="post">
                <input type="hidden" name="id" id="id" value="${book.id}">
                <div class="mb-3 form-floating">
                    <input type="text" class="form-control" placeholder="Nhập tên sách" name="title" id="title" value="${book.title}">
                    <label for="title" class="form-label">Nhập title</label>
                </div>
                <div class="mb-3 form-floating">
                    <input type="text" class="form-control" placeholder="Nhập số trang sách" name="page_size"
                           id="page_size" value="${book.pageSize}">
                    <label for="page_size" class="form-label">Nhập trang sách</label>
                </div>
                <div class="mb-3 form-floating">
                    <input type="text" class="form-control" placeholder="Nhập tên tác giả" name="author" id="author" value="${book.author}">
                    <label for="author" class="form-label">Nhập tên tác giả</label>
                </div>
                <div class="mb-3 form-floating">
                    <input type="text" class="form-control" placeholder="Nhập phân loại" name="category" id="category" value="${book.category}">
                    <label for="category" class="form-label">Nhập phân loại</label>
                </div>
                <div class="d-flex justify-content-center">
                    <a href="/books/list" class="btn btn-secondary">Hủy</a>
                    <button class="btn btn-primary mx-2">Lưu</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
