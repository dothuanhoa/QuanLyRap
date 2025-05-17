<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <html lang="en">

        <head>
            <meta charset="UTF__8">
            <title>Ocean Cinema</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
            <link rel="stylesheet" href="/css/style.css" type="text/css">
            <link rel="stylesheet" href="/css/main.css" type="text/css">
        </head>

        <body>
            <div class="header">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-2">
                            <a href=""><img src="/img/header-logo.png" alt="" class="logo"></a>
                        </div>
                        <div class="col-lg-10">
                            <div class="row header-top">
                                <div class="col-lg-1 offset-lg-2">
                                    <a href="/cus-about-us">Giới thiệu</a>
                                </div>
                                <div class="col-lg-1">
                                    <a href="">Sự kiện</a>
                                </div>
                                <div class="col-lg-1">
                                    <a href="">Dịch vụ</a>
                                </div>
                                <div class="col-lg-1">
                                    <a href="">Tuyển dụng</a>
                                </div>
                                <div class="col-lg-1">
                                    <a href="">Liên hệ</a>
                                </div>
                                <div class="col-lg-2 offset-lg-2">
                                    <a href="/customer/${khachHang.idkh}/logout">Đăng xuất</a>
                                    <a class="login" href="/customer/edit-profile">Tài Khoản</a>

                                </div>
                            </div>
                            <div class="row header-bottom">
                                <div class="col-lg-2 offset-lg-1">
                                    <a href="/customer/${khachHang.idkh}">Trang chủ</a>
                                </div>
                                <div class="col-lg-1">
                                    <a href="/customer/${khachHang.idkh}/cus-movie">Phim</a>
                                </div>
                                <div class="col-lg-1" style="width:12%">
                                    <a href="">Ưu đãi</a>
                                </div>
                                <div class="col-lg-2">
                                    <a href="">Rạp & Vé</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="hero">
                <img src="/img/hero.png" class="img-fluid" style="width:100%" alt="">
            </div>

            <div class="main">
                <div class="row">
                    <div class="col-lg-6 offset-lg-3 rapChoice">
                        Mua vé Online<br />
                        <span>(*)</span>Chọn vào xuất chiếu để đặt vé
                        <div class="row g-2 justify-content-center rapOption">
                            <div class="col-md-3">
                                <select class="form-select">
                                    <option>Rạp Cao Lỗ</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <select class="form-select">
                                    <option>Chọn Phim</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <select class="form-select">
                                    <option>Chọn Lịch</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="phimButton">
                        <a href="/customer/${khachHang.idkh}/cus-movie">
                            <h2 class="nowMovie">Phim Đang Chiếu</h2>
                        </a>
                        <a href="/customer/${khachHang.idkh}/cus-movie">
                            <h2 class="newMovie">Phim Sắp chiếu</h2>
                        </a>
                    </div>
                    <div class="row product-item" id="product-container">
                        <!-- Phim 1 -->
                        <div class="col-lg-3">
                            <div class="movie-card">
                                <a href="#"><img src="/img/product/movie2.png"></a>
                                <div class="movie-tags my-2">
                                    <span class="badge bg-danger">T16</span>
                                    <span class="badge bg-warning text-dark">Phụ đề</span>
                                    <span class="badge bg-info">2D</span>
                                </div>
                                <a href="#">
                                    <h4>THÁM TỬ KIÊN: KỲ ÁN KHÔNG ĐẦU</h4>
                                </a>
                                <div class="movie-category">Thể loại phim: <span>Thriller</span></div>
                            </div>
                        </div>
                        <!-- Phim 2 -->
                        <div class="col-lg-3">
                            <div class="movie-card">
                                <a href="#"><img src="/img/product/movie3.png"></a>
                                <div class="movie-tags my-2">
                                    <span class="badge bg-danger">T16</span>
                                    <span class="badge bg-warning text-dark">Phụ đề</span>
                                    <span class="badge bg-info">2D</span>
                                </div>
                                <a href="#">
                                    <h4>TÌM XÁC: MA KHÔNG ĐẦU</h4>
                                </a>
                                <div class="movie-category">Thể loại phim: <span>Thriller</span></div>
                            </div>
                        </div>
                        <!-- Phim 3 -->
                        <div class="col-lg-3">
                            <div class="movie-card">
                                <a href=""><img src="/img/product/movie5.png"></a>
                                <div class="movie-tags my-2">
                                    <span class="badge bg-danger">T16</span>
                                    <span class="badge bg-warning text-dark">Phụ đề</span>
                                    <span class="badge bg-info">2D</span>
                                </div>
                                <a href="#">
                                    <h4>ĐỊA ĐẠO: MẶT TRỜI TRONG BÓNG TỐI</h4>
                                </a>
                                <div class="movie-category">Thể loại phim: <span>Thriller</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="container dot-group">
                        <label>
                            <input type="radio" name="selector" checked>
                            <span class="dot-label"></span>
                        </label>
                        <label>
                            <input type="radio" name="selector">
                            <span class="dot-label"></span>
                        </label>
                        <label>
                            <input type="radio" name="selector">
                            <span class="dot-label"></span>
                        </label>
                    </div>
                    <div class="container view-all">
                        <a href="/customer/${khachHang.idkh}/cus-movie" class="">Xem Tất Cả</a>
                    </div>
                </div>
                <div class="container-fluid oceanday">
                    <img src="/img/oceanday.png" width="100%"></img>
                </div>
            </div>

            <footer class="footer row">
                <div class="container-fluid col-lg-8">
                    <div class="row">
                        <div class="col-lg-10 offset-lg-2 footer-top">
                            <a href="/customer/${khachHang.idkh}/cus-movie">LỊCH CHIẾU</a>
                            <a href="/customer/${khachHang.idkh}/cus-movie">PHIM </a>
                            <a href="">RẠP & GIÁ VÉ </a>
                            <a href="">ƯU ĐÃI </a>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-lg-10 offset-lg-2 footer-mid">
                            <a href="/customer/${khachHang.idkh}/cus-about-us">GIỚI THIỆU </a>
                            <a href="">SỰ KIỆN </a>
                            <a href="">DỊCH VỤ </a>
                            <a href="">TUYỂN DỤNG </a>
                            <a href="">ĐIỀU KHOẢN CHUNG </a>
                            <a href="">LIÊN HỆ</a>
                        </div>
                    </div>
                    <div class="footer-bottom">
                        <strong>CÔNG TY TNHH OCEAN CINEMAS</strong><br />
                        Địa chỉ: 180 Cao Lỗ, Phường 4, Quận 8, TP.HCM / Email: contact@stu.edu.vn<br />
                        Số ĐKKD: 03126xxxxx - Ngày cấp: 26/04/2025 (Đăng ký thay đổi lần 1) / Nơi cấp: Sở kế hoạch và
                        đầu
                        tư<br />
                        thành phố Hồ Chí Minh<br />
                        Copyright ©2025 OCEAN Cinemas. All rights reserved.<br />
                    </div>
                </div>
                <div class="col-lg-4 footer-right">
                    <div class="support">
                        <h2>TỔNG ĐÀI HỖ TRỢ</h2>
                        <h3>Rạp Cao Lỗ<br />(028) 38 505 520 <img src="/img/phone.png"></h3>
                    </div>
                    <img src="/img/footer-logo.png" class="footer-logo">
                </div>
            </footer>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        </body>

        </html>