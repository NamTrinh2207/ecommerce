<%--
  Created by IntelliJ IDEA.
  User: 84983
  Date: 3/16/2023
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/css/information.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container rounded bg-white mt-5">
  <div class="row">
    <div class="col-md-4 border-right">
      <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" src="https://scontent.fhan17-1.fna.fbcdn.net/v/t39.30808-6/329046286_590378932563962_6554507587873333962_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=wzmv8xdI_9EAX9gmPsm&_nc_ht=scontent.fhan17-1.fna&oh=00_AfBQX4OKaPu6nq7FgeUBs3Ky-cdoDU7wEH8F2uWPmB7OzQ&oe=6417DE47" width="90"><span class="font-weight-bold">John Doe</span><span class="text-black-50">Quản Lý</span><span>Đoành Đoành</span></div>
    </div>
    <div class="col-md-8">
      <div class="p-3 py-5">
        <div class="d-flex justify-content-between align-items-center mb-3">
          <div class="d-flex flex-row align-items-center back"><i class="fa fa-long-arrow-left mr-1 mb-1"></i>
            <h6><a href="/HomePageServlet" >Back to home</a></h6>
          </div>
          <h6 class="text-right">Edit Profile</h6>
        </div>
        <div class="row mt-2">
          <div class="col-md-6"><input type="text" class="form-control" placeholder="id" value=""></div>
          <div class="col-md-6"><input type="text" class="form-control" value="" placeholder="name"></div>
        </div>
        <div class="row mt-3">
          <div class="col-md-6"><input type="text" class="form-control" placeholder="Email" value=""></div>
          <div class="col-md-6"><input type="text" class="form-control" value="" placeholder="Phone number"></div>
        </div>
        <div class="row mt-3">
          <div class="col-md-6"><input type="text" class="form-control" placeholder="address" value=""></div>
          <div class="col-md-6"><input type="text" class="form-control" value="" placeholder="Country"></div>
        </div>
        <div class="row mt-3">
          <div class="col-md-6"><input type="text" class="form-control" placeholder=" code" value=""></div>
          <div class="col-md-6"><input type="text" class="form-control" value="comment" placeholder=""></div>
        </div>
        <div class="mt-5 text-right"><button class="btn btn-primary profile-button" type="button">Save Profile</button></div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
