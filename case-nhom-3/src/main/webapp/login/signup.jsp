<%--
  Created by IntelliJ IDEA.
  User: 84983
  Date: 3/13/2023
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Bootstrap Sign up Form with Rounded Social Buttons</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <style>
    body {
      background: #dfe7e9;
      font-family: 'Roboto', sans-serif;
    }
    .form-control {
      font-size: 16px;
      transition: all 0.4s;
      box-shadow: none;
    }
    .form-control:focus {
      border-color: #b85c5c;
    }
    .form-control, .btn {
      border-radius: 50px;
      outline: none !important;
    }
    .signup-form {
      width: 480px;
      margin: 0 auto;
      padding: 30px 0;
    }
    .signup-form form {
      border-radius: 5px;
      margin-bottom: 20px;
      background: #fff;
      box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
      padding: 40px;
    }
    .signup-form a {
      color: #b86d5c;
    }
    .signup-form h2 {
      text-align: center;
      font-size: 34px;
      margin: 10px 0 15px;
    }
    .signup-form .hint-text {
      color: #999;
      text-align: center;
      margin-bottom: 20px;
    }
    .signup-form .form-group {
      margin-bottom: 20px;
    }
    .signup-form .btn {
      font-size: 18px;
      line-height: 26px;
      font-weight: bold;
      text-align: center;
    }
    .signup-btn {
      text-align: center;
      border-color: #b85f5c;
      transition: all 0.4s;
    }
    .signup-btn:hover {
      background: #b85c5c;
      opacity: 0.8;
    }
    .or-seperator {
      margin: 50px 0 15px;
      text-align: center;
      border-top: 1px solid #e0e0e0;
    }
    .or-seperator b {
      padding: 0 10px;
      width: 40px;
      height: 40px;
      font-size: 16px;
      text-align: center;
      line-height: 40px;
      background: #fff;
      display: inline-block;
      border: 1px solid #e0e0e0;
      border-radius: 50%;
      position: relative;
      top: -22px;
      z-index: 1;
    }
    .social-btn .btn {
      color: #fff;
      margin: 10px 0 0 15px;
      font-size: 15px;
      border-radius: 50px;
      font-weight: normal;
      border: none;
      transition: all 0.4s;
    }
    .social-btn .btn:first-child {
      margin-left: 0;
    }
    .social-btn .btn:hover {
      opacity: 0.8;
    }
    .social-btn .btn-primary {
      background: #507cc0;
    }
    .social-btn .btn-info {
      background: #64ccf1;
    }
    .social-btn .btn-danger {
      background: #df4930;
    }
    .social-btn .btn i {
      float: left;
      margin: 3px 10px;
      font-size: 20px;
    }
  </style>
</head>
<body>
<div class="signup-form">
  <form action="/examples/actions/confirmation.php" method="post">
    <h2>Create an Account</h2>
    <p class="hint-text">Sign up with your social media account or email address</p>
    <div class="social-btn text-center">
      <a href="#" class="btn btn-primary btn-lg"><i class="fa fa-facebook"></i> Facebook</a>
      <a href="#" class="btn btn-info btn-lg"><i class="fa fa-twitter"></i> Twitter</a>
      <a href="#" class="btn btn-danger btn-lg"><i class="fa fa-google"></i> Google</a>
    </div>
    <div class="or-seperator"><b>or</b></div>
    <div class="form-group">
      <input type="text" class="form-control input-lg" name="username" placeholder="Username" required="required">
    </div>
    <div class="form-group">
      <input type="email" class="form-control input-lg" name="email" placeholder="Email Address" required="required">
    </div>
    <div class="form-group">
      <input type="password" class="form-control input-lg" name="password" placeholder="Password" required="required">
    </div>
    <div class="form-group">
      <input type="password" class="form-control input-lg" name="confirm_password" placeholder="Confirm Password" required="required">
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-success btn-lg btn-block signup-btn">Sign Up</button>
    </div>
  </form>
  <div class="text-center">Already have an account? <a href="login.jsp">Login here</a></div>
</div>
</body>
</html>