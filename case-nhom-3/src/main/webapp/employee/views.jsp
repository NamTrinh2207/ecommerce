<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/13/2023
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees details</title>
</head>
<body>
<h1>Employees details</h1>
<table>
    <tr>
        <td>ID: </td>
        <td>${requestScope.employee.id}</td>
    </tr>
    <tr>
        <td>mã NV: </td>
        <td>${requestScope.employee.code}</td>
    </tr>
    <tr>
        <td>Họ và tên: </td>
        <td>${requestScope.employee.name}</td>
    </tr>
    <tr>
        <td>Ngày sinh: </td>
        <td>${requestScope.employee.date}</td>
    </tr>
    <tr>
        <td>Địa chỉ: </td>
        <td>${requestScope.employee.address}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${requestScope.employee.email}</td>
    </tr>
    <tr>
        <td>SĐT: </td>
        <td>${requestScope.employee.phone}</td>
    </tr>
</table>
<p>
    <a href="<c:url value="/employees"/>">Back to employees list</a>
</p>
</body>
</html>
