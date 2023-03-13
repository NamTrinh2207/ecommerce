<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/CategoryServlet?action=create">Create new customer</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
    </tr>
    <c:forEach items='${category}' var="p">
        <tr>
            <td><a href="/CategoryServlet?action=view&id=${p.getId()}">${p.categoriesName}</a></td>
            <td><a href="/CategoryServlet?action=edit&id=${p.getId()}">edit</a></td>
            <td><a href="/CategoryServlet?action=delete&id=${p.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>