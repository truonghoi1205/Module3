<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header d-flex justify-content-between ">
            <h1>List Book</h1>
            <a href="/books?action=create" class="btn btn-success" style="padding: 15px 10px 0 ">Add new Student</a>
        </div>
        <div class="card-body">
            <table class="table table-hover text-center">
                <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Author</th>
                    <th>Hành động</th>
                </tr>
                <c:forEach var="book" items="${bookList}" varStatus="status">
                    <tr class="align-middle">
                        <td>${status.count}</td>
                        <td>${book.getName()}</td>
                        <td>${book.getPrice()}</td>
                        <td class="text-start" style="width: 550px">${book.getDescription()}</td>
                        <td>${book.getAuthor()}</td>
                        <td><a href="/books?action=delete&id=${book.id}" class="btn btn-danger">xóa</a>
                            <a href="/books?action=update&id=${book.id}" class="btn btn-primary">Sửa</a></td>

                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>


</body>
</html>
