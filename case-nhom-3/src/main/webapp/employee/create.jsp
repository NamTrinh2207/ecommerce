<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/13/2023
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new employee</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Employee</h2>
            </caption>
            <tr>
                <th>Mã NV</th>
                <td>
                    <input type="text" name="code" id="code"/>
                </td>
            </tr>
            <tr>
                <th>Họ và tên</th>
                <td>
                    <input type="text" name="name" id="name"/>
                </td>
            </tr>
            <tr>
                <th>Năm sinh</th>
                <td>
                    <input type="text" name="date" id="date"/>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ</th>
                <td>
                    <input type="text" name="address" id="address"/>
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="email" id="email"/>
                </td>
            </tr>
            <tr>
                <th>SĐT</th>
                <td>
                    <input type="text" name="phone" id="phone"/>
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
