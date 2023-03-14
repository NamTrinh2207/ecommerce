<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/productServlet?action=create">Create new customer</a>
</p>
<form action="/productServlet?action=search" method="post">
    <p>
        <a>Search</a>
        <input type="text" name="name">
        <input type="submit" value="search">
    </p>
</form>

<table border="1">
    <tr>
        <td>Name</td>
        <td>Code</td>
        <td>price</td>
        <td>img</td>
        <td>des</td>
    </tr>
    <c:forEach items='${product}' var="p">
        <tr>
            <td><a href="/productServlet?action=view&id=${p.getId()}">${p.name}</a></td>
            <td>${p.code}</td>
            <td>${p.price}</td>
            <td>${p.img}</td>
            <td>${p.describe}</td>
            <td><a href="/productServlet?action=edit&id=${p.getId()}">edit</a></td>
            <td><a href="/productServlet?action=delete&id=${p.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>