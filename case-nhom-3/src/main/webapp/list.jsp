<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/CustomerServlet?action=create">Create new customer</a>
</p>
<form action="/CustomerServlet?action=sorf" method="post">
    <p>
        <a>sorf</a>
        <input type="submit" value="sorf">
    </p>
</form>

<form method="post">
    <select>
        <option>test</option>
        <option><form action="/CustomerServlet?action=sorf" method="post">
            <p>
                <input type="submit" value="sorf">
            </p>
        </form></option>
        <option></option>
    </select>
</form>
<table border="1">
    <tr>
        <td>code</td>
        <td>name</td>
        <td>date</td>
        <td>address</td>
        <td>Email</td>
        <td>phone</td>
    </tr>
    <c:forEach items='${customer}' var="p">
        <tr>
            <td><a href="/CustomerServlet?action=view&id=${p.getId()}">${p.code}</a></td>
            <td>${p.name}</td>
            <td>${p.date}</td>
            <td>${p.address}</td>
            <td>${p.email}</td>
            <td>${p.phone}</td>
            <td><a href="/CustomerServlet?action=edit&id=${p.getId()}">edit</a></td>
            <td><a href="/CustomerServlet?action=delete&id=${p.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>