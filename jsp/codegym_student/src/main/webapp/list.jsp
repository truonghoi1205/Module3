<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/24/2024
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Danh sách học viên</h1>

<c:choose>
    <c:when test="${empty students}">
        <p>Danh sách rỗng.</p>
    </c:when>
    <c:otherwise>
        <table border="1">
            <tr>
                <th>Mã học viên</th>
                <th>Tên học viên</th>
                <th>Giới tính</th>
                <th>Điểm số</th>
                <th>Xếp loại</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.gender}</td>
                    <td>${student.point}</td>
                    <td>${student.getGrade()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
</body>
</html>
