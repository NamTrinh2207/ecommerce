<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/CustomerServlet">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>code:</td>
                <td><input type="text" name="code" value="${customer.getCode()}"></td>
            </tr>            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${customer.getName()}"></td>
            </tr>            <tr>
                <td>date:</td>
                <td><input type="text" name="date" value="${customer.getDate()}"></td>
            </tr>            <tr>
                <td>address:</td>
                <td><input type="text" name="address" value="${customer.getAddress()}"></td>
            </tr>            <tr>
                <td>email:</td>
                <td><input type="text" name="email" value="${customer.getEmail()}"></td>
            </tr>            <tr>
                <td>phone:</td>
                <td><input type="text" name="phone" value="${customer.getPhone()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
