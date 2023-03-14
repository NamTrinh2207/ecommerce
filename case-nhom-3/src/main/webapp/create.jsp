<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <a href="/CustomerServlet">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Cate information</legend>
        <table>
            <tr>
                <td>code:</td>
                <td><input type="text" name="code"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>date</td>
                <td><input type="text" name="date"></td>
            </tr>
            <tr>
                <td>address:</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td>email:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>phone:</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create pro|"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
