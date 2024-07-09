<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/8/2024
  Time: 8:45 PM
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
<div class="container py-5">
    <div class="d-flex justify-content-between p-3 shadow-sm bg-white mb-3 align-items-center rounded">
        <a href="/products/list" class="text-decoration-none text-secondary mb-0 h2">Quản lý sản phẩm rau củ quả</a>
        <form action="/products/search" class="d-flex m-0">
            <input type="text" name="keyword" class="form-control form-control-sm me-2 " style="width: 300px">
            <button class="btn btn-sm btn-outline-secondary w-25">Tìm kiếm</button>
        </form>
        <form action="/products/searchByCategory" class="d-flex m-0">
                <select class="form-select form-select-sm" style="width: 150px">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
        </form>
        <a href="/products/create" class="btn btn-outline-primary btn-sm ">Thêm mới</a>
    </div>
    <table class="table table-hover table-bordered mt-5">
        <thead>
        <tr>
            <th>#</th>
            <th>Mã sản phẩm</th>
            <th>Tên</th>
            <th>Đơn vị tính</th>
            <th>Giá</th>
            <th>Loại hàng hóa</th>
            <th>Ngày thu hoạch</th>
            <th>Chỉnh sửa</th>
            <th>Xóa</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${product.sku}</td>
                <td>${product.name}</td>
                <td>${product.unit}</td>
                <td><fmt:formatNumber value="${product.price}"/></td>
                <td>${product.categoryName}</td>
                <td>${product.day_th}</td>
                <td><a href="/products/update?id=${product.id}" class="btn btn-outline-success btn-sm">Sửa</a></td>
                <td><a class="btn btn-sm btn-outline-danger" data-bs-toggle="modal"
                       data-bs-target="#product-${product.id}">Xóa</a>
                    <div class="modal" tabindex="-1" id="product-${product.id}">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-body">
                                    <p class="p-3 text-start">Bạn có muốn xóa sản phẩm <span
                                            class="fw-bold">${product.name}</span> không?</p>
                                    <div class="text-end">
                                        <button type="button" class="btn btn-sm btn-outline-secondary"
                                                data-bs-dismiss="modal">
                                            Hủy
                                        </button>
                                        <a href="/products/delete?id=${product.id}"
                                           class="btn btn-sm btn-outline-danger">Xóa</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
