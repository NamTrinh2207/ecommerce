<%--
  Created by IntelliJ IDEA.
  User: 84983
  Date: 3/13/2023
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%><link rel="stylesheet" href="/css/cart.css">
-%><link rel="stylesheet" href="/js/cart.js">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="myModal" class="modal">
  <div class="modal-content">
    <div class="modal-header">
      <h5 class="modal-title">Giỏ Hàng</h5>
    </div>
    <div class="modal-body">
      <div class="cart-row">
        <span class="cart-item cart-header cart-column">Sản Phẩm</span>
        <span class="cart-price cart-header cart-column">Giá</span>
        <span class="cart-quantity cart-header cart-column">Số Lượng</span>
      </div>
      <div class="cart-items">
      </div>
      <div class="cart-total">
        <strong class="cart-total-title">Tổng Cộng:</strong>
        <span class="cart-total-price">0VNĐ</span>
      </div>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-secondary close-footer">Đóng</button>
      <button type="button" class="btn btn-primary order">Thanh Toán</button>
    </div>
  </div>
</div>
</body>
</html>
