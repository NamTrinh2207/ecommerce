<%--
 Created by IntelliJ IDEA.
 User: 84983
 Date: 3/13/2023
 Time: 10:59 PM
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>List Order</title>
    <script src="<c:url value="/js/jquery-3.1.1.min.js"/>" type='text/javascript'></script>
    <link href='<c:url value="/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css"/>' rel='stylesheet' type='text/css'>
    <script src='<c:url value ="/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"/>' type='text/javascript'></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        * {
            font-family: 'Roboto', sans-serif;
        }

        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Roboto', sans-serif;
        }

        .table-responsive {
            margin: 30px 0;
        }

        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            padding-bottom: 10px;
            margin: 0 0 10px;
            min-width: 100%;
        }

        .table-title h2 {
            margin: 8px 0 0;
            font-size: 22px;
        }

        .search-box {
            position: relative;
            float: right;
            margin-bottom: 30px;
        }

        .search-box input {
            height: 34px;
            border-radius: 20px;
            padding-left: 35px;
            border-color: #ddd;
            box-shadow: none;
        }

        .search-box input:focus {
            border-color: #3FBAE4;
        }

        .search-box i {
            color: #a0a5b1;
            position: absolute;
            font-size: 19px;
            top: 8px;
            left: 10px;
        }

        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
        }

        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }

        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table td:last-child {
            width: 130px;
        }

        table.table td a {
            color: #a0a5b1;
            display: inline-block;
            margin: 0 5px;
        }

        table.table td a.view {
            color: #03A9F4;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #E34724;
        }

        table.table td i {
            font-size: 19px;
        }

        .pagination {
            float: right;
            margin: 0 0 5px;
        }

        .pagination li a {
            border: none;
            font-size: 95%;
            width: 30px;
            height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 30px !important;
            text-align: center;
            padding: 0;
        }

        .pagination li a:hover {
            color: #666;
        }

        .pagination li.active a {
            background: #03A9F4;
        }

        .pagination li.active a:hover {
            background: #0397d6;
        }

        .pagination li.disabled i {
            color: #ccc;
        }

        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }

        .hint-text {
            float: left;
            margin-top: 6px;
            font-size: 95%;
        }

        .delete {
            cursor: pointer;
        }
        .pagination{
            display: inline-block;
            float: left;
        }
        .pagination a{
            color: #ffffff;
            background-color: #03A9F4;
            font-size: 16px;
            float: left;
            padding: 3px 10px;
            text-decoration: none;
            border-radius: 5px;
            margin-left: 3px;
        }

        .pagination a.active{
            background-color: #f6a906;
            color: white;
        }
        .pagination a:hover:not(.active){
            background-color: #0069d9;
            transition: 0.8s;
            color: white;
        }
        .table-title h2 {
            margin: 8px 0 0;
            font-size: 45px;
        }
        .page-link {
            position: relative;
            display: block;
            padding: 0.5rem 0.75rem;
            line-height: 1.25;
            color: white;
            background-color: #007bff;
            border: 1px solid #007bff;
            margin-left: 15px;
            border-radius: 4px;
            transition: 0.8s;
        }
    </style>
    <script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
</head>
<body>
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2>ORDER <b>LIST</b></h2></div>
                </div>
                <c:url value="/orders?action=searchByDate" var="searchByDate"/>
                <form action="${searchByDate}" method="post">
                    <div class="col-sm-4 float-right">
                      <input type='text' class="form-control" data-provide="datepicker" name="startDate" placeholder='Từ ngày' style='width: 300px;' >
                      <input type='text' class="form-control" data-provide="datepicker" name="endDate" placeholder="Đến ngày" style='width: 300px;' > <br>
                        <button type="submit" class="form-control">Tìm kiếm</button>
                    </div>

                </form>
                <form>
                    <div class="col-sm-4 float-right">
                        <br>
                        <div class="search-box">
                            <i class="material-icons">&#xE8B6;</i>
                            <input name="name" type="text" class="form-control" placeholder="Tìm kiếm hóa đơn theo Id">
                        </div>
                    </div>
                </form>
            </div>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Customer ID <i class="fa fa-sort"></i></th>
                    <th>Employee Id</th>
                    <th>Order Date</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.orders}" var="order">
                    <tr>
                        <td><c:out value="${order.id}"/></td>
                        <td><c:out value="${order.customer_id}"/></td>
                        <td><c:out value="${order.employee_id}"/></td>
                        <td><fmt:formatDate value="${order.orderDate}" type="date" pattern="dd-MM-yyyy"/></td>
                        <td>
                            <a href="<c:url value="/employees?action=view&id=${e.getId()}"/>" class="view" title="View"
                               data-toggle="tooltip"><i
                                    class="material-icons">&#xE417;</i></a>
                            <a href="<c:url value="/employees?action=edit&id=${e.getId()}"/>" class="edit" title="Edit"
                               data-toggle="tooltip"><i
                                    class="material-icons">&#xE254;</i></a>
                            <a onclick="delById('${e.getId()}')" class="delete" title="Delete" data-toggle="tooltip"><i
                                    class="material-icons">&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        $('#datepicker').datepicker();
    });
</script>
</body>
</html>
