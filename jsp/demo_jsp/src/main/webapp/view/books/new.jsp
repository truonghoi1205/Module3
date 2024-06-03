<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/29/2024
  Time: 1:34 PM
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
<div class="container ">
    <div class="card">
        <div class="card-header">
            <h3>Thêm sách</h3>
        </div>
        <div class="card-body">
            <form action="/books/new" method="post">
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingName" placeholder="Tên sách" name="name">
                    <label for="floatingName">Tên sách</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="number" class="form-control" id="floatingPrice" placeholder="Giá" name="price">
                    <label for="floatingPrice">Giá</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingDescription" placeholder="Mô tả" name="description">
                    <label for="floatingDescription">Mô tả</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingAuth" placeholder="Tác giả" name="auth">
                    <label for="floatingAuth">Tác giả</label>
                </div>
                <div>
                    <input type="submit" name="Thêm" value="Thêm"/>
                </div>
            </form>
        </div>

    </div>
</div>

</body>
</html>
