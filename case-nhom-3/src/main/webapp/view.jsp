<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="/productServlet">Back to customer list</a>
</p>
<table>
    <tr>
        <td>code: </td>
        <td>${requestScope["product"].getCode()}</td>
    </tr>
    <tr>
        <td>price: </td>
        <td>${requestScope["product"].getPrice()}</td>
    </tr>
    <tr>
        <td>img: </td>
        <td>${requestScope["product"].getImg()}</td>
    </tr>
    <tr>
        <td>describe:</td>
        <td>${requestScope["product"].getDescribe()}</td>
    </tr>
</table>
</body>
</html>
private long id;
private String code;
private double price;
private String img;
private String describe;