<%--
  Created by IntelliJ IDEA.
  User: 84983
  Date: 3/13/2023
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Bootstrap Sign in Form with Avatar Icon</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <style>
    body {
      color: #4e4e4e;
      background: #e2e2e2;
      font-family: 'Roboto', sans-serif;
    }
    .form-control {
      font-size: 16px;
      background: #f2f2f2;
      box-shadow: none !important;
      border-color: transparent;
    }
    .form-control:focus {
      border-color: #d3d3d3;
    }
    .form-control, .btn {
      border-radius: 2px;
    }
    .login-form {
      width: 380px;
      margin: 0 auto;
      font-size: 15px;
    }
    .login-form h2 {
      margin: 0;
      padding: 30px 0;
      font-size: 34px;
    }
    .login-form .avatar {
      margin: 0 auto 30px;
      width: 100px;
      height: 100px;
      border-radius: 50%;
      z-index: 9;
      background: #ef3b3a;
      padding: 15px;
      box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
    }
    .login-form .avatar img {
      width: 100%;
    }
    .login-form form {
      color: #7a7a7a;
      border-radius: 4px;
      margin-bottom: 15px;
      background: #fff;
      box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
      padding: 30px;
    }
    .login-form .btn, .login-form .btn:active {
      font-weight: bold;
      background: #ef3b3a !important;
      border: none;
      margin-bottom: 20px;
    }
    .login-form .btn:hover, .login-form .btn:focus {
      background: #ed2121 !important;
    }
    .login-form a {
      color: #ef3b3a;
    }
    .login-form form a {
      color: #ef3b3a;
    }
    .login-form a:hover, .login-form form a:hover {
      text-decoration: underline;
    }
    .hint-text {
      color: #999;
      text-align: center;
    }
    .form-footer {
      padding-bottom: 15px;
      text-align: center;
    }
  </style>
</head>
<body>
<div class="login-form">
  <h2 class="text-center">Member Login</h2>
  <form action="/examples/actions/confirmation.php" method="post">
    <div class="avatar">
      <img src="https://www.tutorialrepublic.com/examples/images/avatar.png" alt="Avatar">
    </div>
    <div class="form-group">
      <input type="text" class="form-control input-lg" name="username" placeholder="Username" required="required">
    </div>
    <div class="form-group">
      <input type="password" class="form-control input-lg" name="password" placeholder="Password" required="required">
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Sign in</button>
    </div>
    <p class="hint-text">Don't have an account? <a href="#">Sign up here</a></p>
  </form>
  <div class="form-footer"><a href="#">Forgot Your Password?</a></div>
</div>
</body>
</html>