<%@ page import="com.example.user_manager.models.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <div class="card-header d-flex justify-content-between">
                <div>
                    <h1>User Management</h1>
                </div>
                <div>
                    <form action="users">
                        <input type="text" name="keyword" placeholder="search">
                        <input type="hidden" name="action" value="search">
                        <button type="submit" >tìm</button>
                    </form>
                    <form action="users">
                        <button type="submit" name="action" value="sort">sx</button>
                    </form>
                </div>
                <div>
                    <h2>
                        <a href="/users?action=create">Add New User</a>
                    </h2>
                </div>
            </div>
        </div>
        <div class="card-body">
            <div align="center container">
                <table class="table text-center">
                    <h2 class="text-center">List of Users</h2>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Country</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="user" items="${listUser}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.country}"/></td>
                            <td>
                                <a href="/users?action=edit&id=${user.id}">Edit</a>
                                <a href="/users?action=delete&id=${user.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>