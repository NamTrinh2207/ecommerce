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
    <a href="/productServlet">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Cate information</legend>
        <table>
            <tr>
                <td>code:</td>
                <td><input type="text" name="code"></td>
            </tr><tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr><tr>
                <td>price</td>
                <td><input type="text" name="price"></td>
            </tr><tr>
                <td>img:</td>
                <td><input type="text" name="img"></td>
            </tr>
            <tr>
                <td>des:</td>
                <td><input type="text" name="describe"></td>
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
