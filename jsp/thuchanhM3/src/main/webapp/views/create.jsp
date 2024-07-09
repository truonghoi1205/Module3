<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="mx-auto py-5 w-25 mt-3">
    <div>
        <h2 class="text-center text-decoration-none text-secondary mb-0">TRANG THÊM SẢN PHẨM</h2>
    </div>
    <div class="shadow-sm bg-white p-3 mt-3 rounded">
        <form action="/products/create" method="post">
            <div>
                <input type="hidden" id="id" name="id" value="${product.id}">
            </div>
            <div>
                <label class="form-label" for="sku">Thêm mã sản phẩm</label>
                <input type="text" class="form-control" placeholder="VD: MHH-0A14" id="sku" name="sku" value="${product.sku}" pattern="MHH-[A-Z0-9]{4}">
            </div>
            <div>
                <label class="form-label" for="name">Thêm tên sản phẩm</label>
                <input type="text" class="form-control" id="name" name="name" value="${product.name}">
            </div>
            <label class="form-label">Đơn vị tính</label>
                <select class="form-select form-select mb-3" name="unit">
                    <option value="Kg" ${product.unit == 'Kg' ? 'selected' : ''}>Kg</option>
                    <option value="Túi" ${product.unit == 'Túi' ? 'selected' : ''}>Túi</option>
                    <option value="Bó" ${product.unit == 'Bó' ? 'selected' : ''}>Bó</option>
            </select>
            <div>
                <label class="form-label" for="price">Thêm giá</label>
                <input type="text" class="form-control" id="price" name="price" value="${product.price}">
            </div>

            <label class="form-label">Phân loại</label>
            <select class="form-select form-select mb-3" name="categoryId">
                <c:forEach var="item" items="${categories}">
                    <option ${product.categoryId == item.id ? "selected" : ""}
                            value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>
            <div>
                <label class="form-label" for="day_th">Ngày thu hoach</label>
                <input type="date" class="form-control" id="day_th" name="day_th" value="${product.day_th}" required>
            </div>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger mt-2">${errorMessage}</div>
            </c:if>
            <div class="d-flex justify-content-end mt-2">
            <button class="btn btn-primary btn-sm me-2">Lưu</button>
            <a href="/products/list" class="btn btn-sm btn-secondary">Hủy</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
