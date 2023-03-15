<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting customer</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/CustomerServlet">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>code:</td>
                <td>${requestScope["customer"].getCode()}</td>
            </tr>
            <tr>
                <td>name:</td>
                <td>${requestScope["customer"].getName()}</td>
            </tr>
            <tr>
                <td>date:</td>
                <td>${requestScope["customer"].getDate()}</td>
            </tr>
            <tr>
                <td>address:</td>
                <td>${requestScope["customer"].getAddress()}</td>
            </tr>
            <tr>
                <td>email:</td>
                <td>${requestScope["customer"].getEmail()}</td>
            </tr>            <tr>
                <td>phone:</td>
                <td>${requestScope["customer"].getPhone()}</td>
            </tr>


            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td><a href="/CategoryServlet">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
