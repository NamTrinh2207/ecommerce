<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/13/2023
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/employees">List All employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit employee
                </h2>
            </caption>
            <c:if test="${requestScope.employee != null}">
                <input type="hidden" name="id" value="<c:out value='${requestScope.employee.id}' />"/>
            </c:if>
            <tr>
                <th>Mã NV</th>
                <td>
                    <input type="text" name="code" value="<c:out value='${requestScope.employee.code}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Họ và tên</th>
                <td>
                    <input type="text" name="name" value="<c:out value='${requestScope.employee.name}'/>"/>
            </tr>
            <tr>
                <th>Năm sinh</th>
                <td>
                    <input type="text" name="date" value="<c:out value='${requestScope.employee.date}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ</th>
                <td>
                    <input type="text" name="address" value="<c:out value='${requestScope.employee.address}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="email" value="<c:out value='${requestScope.employee.email}'/>"/>
                </td>
            </tr>
            <tr>
                <th>SĐT</th>
                <td>
                    <input type="text" name="phone" value="<c:out value='${requestScope.employee.phone}'/>"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
