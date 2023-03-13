<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <a href="/CategoryServlet">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Cate information</legend>
        <table>
            <tr>
                <td>categoryName:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Cate|"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
