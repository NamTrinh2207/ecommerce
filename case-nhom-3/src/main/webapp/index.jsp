<!DOCTYPE html>
<html>

<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!-- basic -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>lion</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- bootstrap css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- style css -->
    <link rel="stylesheet" href="css/style.css">
    <!-- Responsive-->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- fevicon -->
    <link rel="icon" href="images/fevicon.png" type="image/gif"/>
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
    <!-- Tweaks for older IEs-->
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
          media="screen">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <style>
        * {
            font-family: 'Roboto', sans-serif;
        }

        .img_bg img {
            width: 1600px;
            height: 600px;
        }
    </style>
</head>
<!-- body -->
<body class="main-layout">
<!-- loader  -->
<div class="loader_bg">
    <div class="loader"><img src="images/loading.gif" alt="#"/></div>
</div>

<div class="wrapper">

    <!-- end loader -->
    <div class="sidebar">
        <!-- Sidebar  -->
        <nav id="sidebar">

            <div id="dismiss">
                <i class="fa fa-arrow-left"></i>
            </div>

            <ul class="list-unstyled components">

                <li class="active">
                    <a href="/index.jsp">Trang chủ</a>
                </li>
                <li>
                    <a href="#brand">Thương Hiệu</a>
                </li>
                <li>
                    <a href="#day">Dày</a>
                </li>
                <li>
                    <a href="#jewellery">Trang Sức</a>
                </li>
                <li>
                    <a href="#kids">Trẻ em và Trẻ sơ sinh</a>
                </li>
            </ul>

        </nav>
    </div>

    <div id="content">
        <!-- header -->
        <header>
            <!-- header inner -->
            <div class="head_top">
                <div class="header">

                    <div class="container-fluid">

                        <div class="row">
                            <div class="col-lg-3 logo_section">
                                <div class="full">
                                    <div class="center-desk">
                                        <div class="logo">
                                            <a href="index.html"><img src="images/logo.png" alt="#"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-9">
                                <div class="right_header_info">
                                    <ul>
                                        <li class="menu_iconb">
                                            <a href="#"><img style="margin-right: 15px;" src="icon/1.png" alt="#"/>7213456789</a>
                                        </li>
                                        <li class="menu_iconb">
                                            <a href="login/login.jsp">Đăng Nhập <img style="margin-right: 15px;"
                                                                                     src="icon/5.png" alt="#"/> </a>
                                        </li>
                                        <li class="menu_iconb">
                                            <a href="login/login.jsp">Đăng Xuất<img style="margin-left: 15px;"
                                                                                    src="icon/6.png" alt="#"/></a>
                                        </li>
                                        <li class="tytyu">
                                            <a href="login/cart.jsp"> <img style="margin-right: 15px;" src="icon/2.png"
                                                                           alt="#"/></a>
                                        </li>
                                        <li class="menu_iconb">

                                            <a href="login/searchproduct.jsp"><img style="margin-right: 15px;" src="icon/3.png" alt="#" /></a>

                                        </li>

                                        <li>
                                            <button type="button" id="sidebarCollapse">
                                                <img src="images/menu_icon.png" alt="#"/>
                                            </button>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- end header inner -->

                <!-- end header -->
                <section class="slider_section">
                    <div class="banner_main">
                        <div class="container-fluid padding3">
                            <div class="row">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 mapimg">
                                    <div class="text-bg">
                                        <h1>Tất <br>
                                            Cả <br>
                                            Sản <br>
                                            Phẩm</h1>
                                        <span>Hệ Thống Bán Hàng Lớn Nhất Việt Nam</span>
                                        <a href="#">Mua Ngay</a>
                                    </div>
                                </div>
                                <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12">
                                    <div id="myCarousel" class="carousel slide banner_Client" data-ride="carousel">
                                        <ol class="carousel-indicators">
                                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                            <li data-target="#myCarousel" data-slide-to="1"></li>
                                            <li data-target="#myCarousel" data-slide-to="2"></li>
                                        </ol>
                                        <div class="carousel-inner">
                                            <div class="carousel-item active">
                                                <div class="container">
                                                    <div class="carousel-caption text">
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <div class="img_bg">
                                                                    <figure><img
                                                                            src="images/Banner-dien-may-720x445-a.png"/>
                                                                    </figure>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="carousel-item">
                                                <div class="container">
                                                    <div class="carousel-caption text">
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <div class="img_bg">
                                                                    <figure><img
                                                                            src="images/Banner-may-hut-bui-720x445.png"/>
                                                                    </figure>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="carousel-item">
                                                <div class="container">
                                                    <div class="carousel-caption text">
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <div class="img_bg">
                                                                    <figure><img
                                                                            src="images/Banner-may-loc-nuoc-720x445.png"/>
                                                                    </figure>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

            </div>
        </header>
        <!-- Categories -->
        <div class="Categories">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="title">
                            <h2> THỂ LOẠI</h2>
                            <ul class="categiri">
                                <li class="active"><a href="#">DANH MỤC</a></li>
                                <li><a href="#electrolic">Thiết bị điện tử</a></li>
                                <li><a href="#shoes">Sức khỏe & làm đẹp</a></li>
                                <li><a href="#men">Thời trang nam</a></li>
                                <li><a href="#jewellery">Thời trang nữ</a></li>
                                <li><a href="#giadung">Đồ gia dụng</a></li>
                                <li><a href="#kids">Thể thao & du lịch</a></li>
                                <li><a href="#xemay">Ô tô - Xe máy</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- news brand -->
                <div id="brand" class="brand-bg">
                    <h3>Bán Chạy Nhất</h3>
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="brand-box">
                                <h5>Giảm Giá</h5>
                                <i><img src="https://tse4.mm.bing.net/th?id=OIP.IBXmtN4cRfdZsjtEct2XMwHaKW&pid=Api&P=0"/>
                                </i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="brand-box">
                                <i><img src="https://tse4.mm.bing.net/th?id=OIP.RKEomozF2AJqx9f1uP-PtQHaJ4&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="brand-box">
                                <i><img src="https://tse4.mm.bing.net/th?id=OIP.niwUXpQCgw49zQSiVPkZ5gHaFj&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="brand-box">
                                <i><img src="https://tse1.mm.bing.net/th?id=OIP.eGGXasx8eDDUi56KitaHxgHaGC&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                    </div>
                </div>
                <a class="seemore" href="#">Nhiều Hơn</a>
                <!-- end news brand -->

                <!-- news shoes -->
                <div id="shoes" class="shoes-bg">
                    <h3>Mỹ Phẩm</h3>
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="shoes-box">
                                <h5>Giảm Giá</h5>
                                <i><img src="https://tse1.mm.bing.net/th?id=OIP.Y3_7SLYCS1S7z-eLKGMu0AHaHa&pid=Api&P=0"/>
                                </i>
                                <h4>Mua $<span class="nolmal">100</span></h4>

                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="shoes-box">
                                <i><img src="https://tse3.mm.bing.net/th?id=OIP.WqbtDvR_KsbbmBNfo4ddmgHaFj&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="shoes-box">
                                <i><img src="https://tse1.mm.bing.net/th?id=OIP.MllPUXEix7dYdugo1OjRpgHaHa&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="shoes-box">
                                <i><img src="https://tse1.mm.bing.net/th?id=OIP.Wphwy_m4qHbVK2BR0Z3WbgFSC4&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                    </div>
                </div>
                <a class="seemore" href="#">Nhiều Hơn</a>
            </div>

        </div>
    </div>
    <!-- end news shoes -->

    <!-- end Categories -->

    <section>
        <!--  save -->

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="save">
                        <div class="row">
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                <div class="save_box">
                                    <h3>Đang Giảm 50%</h3>
                                    <a href="#">Mua Ngay</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end save -->
    </section>

    <!-- news Jewellery -->
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div id="jewellery" class="Jewellery-bg">
                    <h3>Trang Sức Mới</h3>
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="Jewellery-box">
                                <h5>Giảm</h5>
                                <i><img src="icon/j1.png"/>
                                </i>
                                <h4>Mua $<span class="nolmal">100</span></h4>

                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="Jewellery-box">
                                <i><img src="icon/j2.png"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="Jewellery-box">
                                <i><img src="icon/j3.png"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="Jewellery-box">
                                <i><img src="icon/j4.png"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                    </div>
                </div>
                <a class="seemore" href="#">Nhiều Hơn</a>
            </div>
        </div>
    </div>
<%--dày--%>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div id="day" class="Jewellery-bg">
                    <h3>Trang Sức Mới</h3>
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="Jewellery-box">
                                <h5>Giảm</h5>
                                <i><img src="https://tse2.mm.bing.net/th?id=OIP.yiG3E-aqetAcc8q5c24xnAHaFD&pid=Api&P=0"/>
                                </i>
                                <h4>Mua $<span class="nolmal">100</span></h4>

                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="Jewellery-box">
                                <i><img src="https://tse4.mm.bing.net/th?id=OIP.7VNmxW83YatryIKb8QLGbwHaEw&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="Jewellery-box">
                                <i><img src="https://tse2.mm.bing.net/th?id=OIP.rcT_HwKV48q-VDoUD7Jj1gHaHa&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="Jewellery-box">
                                <i><img src="https://tse1.mm.bing.net/th?id=OIP.gzrbkYL1rUGt37la7WAGOQHaEw&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                    </div>
                </div>
                <a class="seemore" href="#">Nhiều Hơn</a>
            </div>
        </div>
    </div>



    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div id="xemay" class="Jewellery-bg">
                    <h3>Ô Tô-Xe Máy</h3>
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="Jewellery-box">
                                <h5>Giảm</h5>
                                <i><img src="https://tse2.mm.bing.net/th?id=OIP.RffYYaMdu_GeihgpXoJ0TgHaEK&pid=Api&P=0"/>
                                </i>
                                <h4>Mua $<span class="nolmal">100</span></h4>

                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="Jewellery-box">
                                <i><img src="https://tse2.mm.bing.net/th?id=OIP.4koKjaHyeyz7z0Vg5-eGSgHaEd&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">10000000</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="Jewellery-box">
                                <i><img src="https://tse2.mm.bing.net/th?id=OIP.P8nLoJYBepVO3qSaRB0JfAHaEz&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">10000000</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="Jewellery-box">
                                <i><img src="https://tse2.mm.bing.net/th?id=OIP.R0u4YOiDAojVHN6jez3tJQHaEJ&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">10000000</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                    </div>
                </div>
                <a class="seemore" href="#">Nhiều Hơn</a>
            </div>
        </div>
    </div>


    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div id="giadung" class="Jewellery-bg">
                    <h3>Đồ Gia Dụng</h3>
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="Jewellery-box">
                                <h5>Giảm</h5>
                                <i><img src="https://tse2.mm.bing.net/th?id=OIP.fMJZ62mF88ybkESENA8WRQHaFj&pid=Api&P=0"/>
                                </i>
                                <h4>Mua $<span class="nolmal">100</span></h4>

                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="Jewellery-box">
                                <i><img src="https://tse1.mm.bing.net/th?id=OIP.J07oP8jIbSmKHtYrQWChVQHaE7&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="Jewellery-box">
                                <i><img src="https://tse2.mm.bing.net/th?id=OIP.SUjhGPUp8ls0H49yyI9gDwHaD4&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="Jewellery-box">
                                <i><img src="https://tse1.mm.bing.net/th?id=OIP.dAn1zA3dk-TY5uIgS6rWMgHaEC&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                    </div>
                </div>
                <a class="seemore" href="#">Nhiều Hơn</a>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div id="men" class="Jewellery-bg">
                    <h3>Thời Trang Nam</h3>
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="Jewellery-box">
                                <h5>Giảm</h5>
                                <i><img src="https://tse3.mm.bing.net/th?id=OIP.0GQNTYijqIYTIIlBgffojAAAAA&pid=Api&P=0"/>
                                </i>
                                <h4>Mua $<span class="nolmal">100</span></h4>

                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="Jewellery-box">
                                <i><img src="https://tse2.mm.bing.net/th?id=OIP._L5PqNUPiYZxEBwGR53LsgHaIJ&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="Jewellery-box">
                                <i><img src="https://tse4.mm.bing.net/th?id=OIP.yITsmEXOhlMUjrtt4CN6NgHaEo&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="Jewellery-box">
                                <i><img src="https://tse3.mm.bing.net/th?id=OIP.Az4lQDxbudtGSivgvljD6QHaHa&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                    </div>
                </div>
                <a class="seemore" href="#">Nhiều Hơn</a>
            </div>
        </div>
    </div>
    <!-- end news Jewellery -->
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div id="electrolic" class="Jewellery-bg">
                    <h3>Thiết Bị Điện Tử</h3>
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="Jewellery-box">
                                <h5>Giảm</h5>
                                <i><img src="https://tse3.mm.bing.net/th?id=OIP.w8Jqx1Yb4KNssodBH_EzJwHaE7&pid=Api&P=0"/>
                                </i>
                                <h4>Mua $<span class="nolmal">100</span></h4>

                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                            <div class="Jewellery-box">
                                <i><img src="https://tse1.mm.bing.net/th?id=OIP.Ps_LBG2AWahnS1KNP4WUBwHaHa&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="Jewellery-box">
                                <i><img src="https://tse3.mm.bing.net/th?id=OIP.UG70mq0Qk-2DUFAvGD83iQHaE8&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="Jewellery-box">
                                <i><img src="https://tse4.mm.bing.net/th?id=OIP.blAcpb1--RaFRm-0tJPQ-QHaEv&pid=Api&P=0"/></i>
                                <h4>Giá $<span class="nolmal">100</span></h4>
                            </div>
                            <a class="buynow" href="#">Mua Ngay</a>
                        </div>
                    </div>
                </div>
                <a class="seemore" href="#">Nhiều Hơn</a>
            </div>
        </div>
    </div>

    <!-- news Kids -->
    <div id="kids" class="Kids_background">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="Kids-bg">
                        <h3>Đồ Trẻ Em</h3>
                        <div class="row">
                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                                <div class="Kids-box">

                                    <i><img src="https://tse3.mm.bing.net/th?id=OIP.NJ5wTMLXa2vR4osZZCkvqgHaHa&pid=Api&P=0"/>
                                    </i>
                                    <h4>Giá $<span class="nolmal">100</span></h4>

                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">
                                <div class="Kids-box">
                                    <i><img src="https://tse4.mm.bing.net/th?id=OIP.Uxyxbb0jWz9elTXNU3D8egHaHa&pid=Api&P=0"/></i>
                                    <h4>Giá $<span class="nolmal">100</span></h4>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                                <div class="Kids-box">
                                    <i><img src="https://tse1.mm.bing.net/th?id=OIF.nH04B5Vuj%2bfMwpdt3uZmag&pid=Api&P=0"/></i>
                                    <h4>Giá $<span class="nolmal">100</span></h4>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                                <div class="Kids-box">
                                    <i><img src="https://tse4.mm.bing.net/th?id=OIP.MwlqVd51lzZrEaiAlnc7XwHaFL&pid=Api&P=0"/></i>
                                    <h4>Giá $<span class="nolmal">100</span></h4>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!-- end news Kids -->

    <!--  footer -->
    <footer>
        <div class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="footer_top">
                            <div class="row">
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                    <a href="index.html"> <img class="logo1" src="images/logo1.png"/></a>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                    <ul class="sociel">
                                        <li><a href="#"><i class="fa fa-facebook-f"></i></a></li>
                                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
                        <div class="row">
                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-6 ">
                                <div class="address">
                                    <h3>Liên Hệ Chúng Tôi </h3>
                                    <ul class="loca">
                                        <li>
                                            <a href="https://www.google.com/maps/place/CodeGym/@21.0357101,105.7660288,17z/data=!4m14!1m7!3m6!1s0x313454b9444c676b:0xe713200541b7456d!2sCodeGym!8m2!3d21.0357101!4d105.7682175!16s%2Fg%2F11dxrrzx7t!3m5!1s0x313454b9444c676b:0xe713200541b7456d!8m2!3d21.0357101!4d105.7682175!16s%2Fg%2F11dxrrzx7t"><img
                                                    src="icon/loc.png" alt="#"/></a>Lô 02/MonCity
                                            <br>uk
                                        </li>
                                        <li>
                                            <a href="#"><img src="icon/call.png" alt="#"/></a>+12586954775
                                        </li>
                                        <li>
                                            <a href="https://mail.google.com/"><img src="icon/email.png" alt="#"/></a>Kieuanh@gmail.com
                                        </li>

                                    </ul>

                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="address">
                                    <h3>Dịch Vụ Khách Hàng</h3>
                                    <ul class="Menu_footer">
                                        <li class="active"><a href="#">Tài Khoản</a></li>
                                        <li><a href="#">Yêu Thích</a></li>
                                        <li><a href="#">Giỏ Hàng</a></li>
                                        <li><a href="#">Đăng Xuất</a></li>
                                        <li><a href="#">Đăng Nhập</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="address">
                                    <h3>Danh Sách</h3>
                                    <ul class="Links_footer">
                                        <li class="active"><a href="#">Tài Khoản</a></li>
                                        <li><a href="#">Yêu Thích</a></li>
                                        <li><a href="#">Giỏ Hàng</a></li>
                                        <li><a href="#"> Đăng Xuất</a></li>
                                        <li><a href="#">Đăng Nhập</a></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6 col-sm-6 ">
                                <div class="address">
                                    <h3>Phản Hồi</h3>
                                    <p>Hãy Ủng Hộ Chúng Tôi Băng Cách Đăng Kí </p>
                                    <form class="newtetter">
                                        <input class="tetter" placeholder="Your email" type="text" name="Your email">
                                        <button class="submit">Đăng Kí</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="copyright">
                <div class="container">
                </div>
            </div>
        </div>

    </footer>
    <!-- end footer -->


</div>

<div class="overlay"></div>

<!-- Javascript files-->
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.0.0.min.js"></script>

<!-- sidebar -->
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="js/custom.js"></script>
<script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#sidebar").mCustomScrollbar({
            theme: "minimal"
        });

        $('#dismiss, .overlay').on('click', function () {
            $('#sidebar').removeClass('active');
            $('.overlay').removeClass('active');
        });

        $('#sidebarCollapse').on('click', function () {
            $('#sidebar').addClass('active');
            $('.overlay').addClass('active');
            $('.collapse.in').toggleClass('in');
            $('a[aria-expanded=true]').attr('aria-expanded', 'false');
        });
    });
</script>

<script>
    $(document).ready(function () {
        $(".fancybox").fancybox({
            openEffect: "none",
            closeEffect: "none"
        });

        $(".zoom").hover(function () {

            $(this).addClass('transition');
        }, function () {

            $(this).removeClass('transition');
        });
    });
</script>
<script>
    // This example adds a marker to indicate the position of Bondi Beach in Sydney,
    // Australia.
    function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 11,
            center: {
                lat: 40.645037,
                lng: -73.880224
            },
        });

        var image = 'images/maps-and-flags.png';
        var beachMarker = new google.maps.Marker({
            position: {
                lat: 40.645037,
                lng: -73.880224
            },
            map: map,
            icon: image
        });
    }
</script>
<!-- google map js -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8eaHt9Dh5H57Zh0xVTqxVdBFCvFMqFjQ&callback=initMap"></script>
<!-- end google map js -->
</body>

</html>