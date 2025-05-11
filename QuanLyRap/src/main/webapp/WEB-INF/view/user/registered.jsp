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
            <link rel="stylesheet" href="/css/registered.css" type="text/css">
        </head>

        <body>
            <div class="header">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-2">
                            <a href="#"><img src="/img/header-logo.png" alt="" class="logo"></a>
                        </div>
                        <div class="col-lg-10">
                            <div class="row header-top">
                                <div class="col-lg-1 offset-lg-2">
                                    <a href="/about-us">Giới thiệu</a>
                                </div>
                                <div class="col-lg-1">
                                    <a href="#">Sự kiện</a>
                                </div>
                                <div class="col-lg-1">
                                    <a href="#">Dịch vụ</a>
                                </div>
                                <div class="col-lg-1">
                                    <a href="#">Tuyển dụng</a>
                                </div>
                                <div class="col-lg-1">
                                    <a href="#">Liên hệ</a>
                                </div>
                                <div class="col-lg-2 offset-lg-2">
                                    <a href="/registered">Đăng ký</a>
                                    <a class="login" href="login">Đăng nhập</a>
                                </div>
                            </div>
                            <div class="row header-bottom">
                                <div class="col-lg-2 offset-lg-1">
                                    <a href="#">Trang chủ</a>
                                </div>
                                <div class="col-lg-2" style="width:18%">
                                    <a href="/movie">Lịch chiếu</a>
                                </div>
                                <div class="col-lg-1">
                                    <a href="#">Phim</a>
                                </div>
                                <div class="col-lg-1" style="width:12%">
                                    <a href="#">Ưu đãi</a>
                                </div>
                                <div class="col-lg-2">
                                    <a href="#">Rạp & Vé</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="main">
                <div class="dangnhap">
                    ĐĂNG KÝ
                </div>
                <div class="container">
                    <div class="registeredContainer">
                        <div class="account-info">
                            <h2>THÔNG TIN ĐĂNG NHẬP</h2>
                            <input type="email" id="username" placeholder="Email"><br />
                            <input type="password" id="password" placeholder="Mật khẩu">
                            <input type="repassword" id="repassword" placeholder="Nhập lại mật khẩu">
                            <div id="errorMessage" style="color: red;"></div>
                            <div class="img-container">
                                <img src="/img/resigtered.png">
                            </div>
                        </div>
                        <div>
                            <h2>THÔNG TIN CÁ NHÂN</h2>
                            <div class="self-info">
                                <input type="name" id="name" placeholder="Tên">
                                <input type="lastname" id="lastname" placeholder="Họ">
                                <input type="sex" placeholder="DD/MM/YYYY" onfocus="(this.type='date')"
                                    onclick="(this.type='date')" onblur="if(!this.value)this.type='text'"
                                    class="custom-date">
                                <input type="sex" id="sex" placeholder="Giới tính">
                                <input type="cccd" id="cccd" placeholder="CMND/CCCD">
                                <input type="phone" id="phone" placeholder="Số điện thoại">
                                <input type="address" id="address" placeholder="Địa chỉ">
                                <input type="city" id="city" placeholder="Tỉnh/Thành phố">
                                <input type="district" id="district" placeholder="Quận/Huyện">
                            </div>
                        </div>
                    </div>
                    <div class="registered-bottom">
                        <div class="accept">
                            <input type="checkbox" id="accept">
                            <label for="accept">Tôi đồng ý với Điều khoản & Điều kiện của chương trình</label>
                        </div>
                        <button class="registered-btn" id="registered">ĐĂNG KÝ</button>
                    </div>
                </div>
            </div>

            <footer class="footer row">
                <div class="container-fluid col-lg-8">
                    <div class="row">
                        <div class="col-lg-10 offset-lg-2 footer-top">
                            <a href="/movie">LỊCH CHIẾU</a>
                            <a href="#">PHIM </a>
                            <a href="#">RẠP & GIÁ VÉ </a>
                            <a href="#">ƯU ĐÃI </a>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-lg-10 offset-lg-2 footer-mid">
                            <a href="/registered">GIỚI THIỆU </a>


                            <a href="#">SỰ KIỆN </a>


                            <a href="#">DỊCH VỤ </a>

                            <a href="#">TUYỂN DỤNG </a>

                            <a href="#">ĐIỀU KHOẢN CHUNG </a>

                            <a href="#">LIÊN HỆ</a>
                        </div>
                    </div>
                    <div class="footer-bottom">
                        <strong>CÔNG TY TNHH OCEAN CINEMAS</strong><br />
                        Địa chỉ: 180 Cao Lỗ, Phường 4, Quận 8, TP.HCM / Email: contact@stu.edu.vn<br />
                        Số ĐKKD: 03126xxxxx - Ngày cấp: 26/04/2025 (Đăng ký thay đổi lần 1) / Nơi cấp: Sở kế hoạch
                        và đầu
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
            <script src="/js/registered.js" defer></script>
        </body>

        </html>