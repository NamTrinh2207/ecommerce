<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/13/2023
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="comment" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Employees</title>
    <link rel="stylesheet" href="css/employee.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<section class="intro">
    <div class="bg-image h-100" style="background-color: #f5f7fa;">
        <div class="mask d-flex align-items-center h-100">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body p-0">
                                <div class="table-responsive table-scroll" data-mdb-perfect-scrollbar="true"
                                     style="position: relative; height: 700px">
                                    <table class="table table-striped mb-0">
                                        <thead style="background-color: #002d72;">
                                        <tr>
                                            <th scope="col">ID</th>
                                            <th scope="col">Mã NV</th>
                                            <th scope="col">Họ và tên</th>
                                            <th scope="col">Năm sinh</th>
                                            <th scope="col">Địa chỉ</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">SĐT</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${requestScope.employees}" var="e">
                                            <tr>
                                                <td><c:out value="${e.id}"/></td>
                                                <td><c:out value="${e.code}"/></td>
                                                <td><c:out value="${e.name}"/></td>
                                                <td><c:out value="${e.date}"/></td>
                                                <td><c:out value="${e.address}"/></td>
                                                <td><c:out value="${e.email}"/></td>
                                                <td><c:out value="${e.phone}"/></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>
