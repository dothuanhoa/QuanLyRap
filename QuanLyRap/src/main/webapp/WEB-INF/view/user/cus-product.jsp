<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html lang="en">

        <head>
            <meta charset="UTF__8">
            <title>Ocean Cinema</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
            <link rel="stylesheet" href="/css/product.css" type="text/css">
            <link rel="stylesheet" href="/css/style.css" type="text/css">
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
                                    <a href="/customer/${khachHang.idkh}/cus-about-us">Giới thiệu</a>
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
                                    <a class="login" href="">Tài Khoản</a>
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
            <div class="main">
                <div id="movie">${phim.tenPhim}</div>
                <div class="movie-info row">
                    <div class="col-lg-9">
                        <div class="short-info">
                            <div>Thời lượng:&nbsp;<span id="time">${phim.thoiLuong} phút</span><span
                                    style="padding-left: 30%; font-weight: bold;">Thể
                                    loại:&nbsp;<span id="genre"
                                        style="font-weight: 100;"></span>${phim.theLoai.tenTheLoai}</span></div>

                            <div>Khởi chiếu:&nbsp;<span id="start">${phim.ngayChieu}</span></div>
                        </div>
                        <div class="long-info">
                            <div>Đạo diễn:&nbsp;<span id="director">${phim.daoDien}</span></div>
                            <div>Diễn viên:&nbsp;<span id="actor">${phim.dienVien}</span></div>
                            <div>Ngôn ngữ:&nbsp;<span id="lang"></span>${phim.ngonNgu}</div>
                            <div id="description">>${phim.noiDung}</div>
                        </div>
                    </div>
                    <div class="col-lg-3" id="movie-img"><img src="/img/product-banner/${phim.idPhim}.png"
                            alt="${phim.tenPhim}" class="movie-img"></div>
                </div>
            </div>
            <div class="container-fluid container-fscren">
                <div class="movie-screening">
                    <div class="movie-screening-name"><strong>Lịch chiếu -&nbsp;</strong><span
                            id="movie-screening-name"><Strong>${phim.tenPhim}</Strong></span></div>
                    <div class="movie-screening-container" id="movie-screening">
                        <c:forEach var="lichChieu" items="${phim.lichChieuList}">
                            <div class="date">Ngày ${lichChieu.ngayChieu}</div>
                            <span class="format">2D PHỤ ĐỀ / SUB</span>
                            <br />

                            <c:forEach var="suatChieu" items="${lichChieu.suatChieuList}">
                                <div class="time" style="display: inline-block;margin-top: 20px;">
                                    <a style="background-color: 5AC5FF; color: black; border: none;padding: 5px 10px;"
                                        href="/customer/${khachHang.idkh}/cus-pick-chair?phim=${phim.idPhim}&date=${lichChieu.ngayChieu}&showtime=${suatChieu.thoiGianBatDau}">
                                        ${suatChieu.thoiGianBatDau}
                                    </a>
                                </div>
                            </c:forEach>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <footer class="footer row">
                <div class="container-fluid col-lg-8">
                    <div class="row">
                        <div class="col-lg-10 offset-lg-2 footer-top">
                            <a href="/cus-movie">LỊCH CHIẾU</a>
                            <a href="#">PHIM </a>
                            <a href="#">RẠP & GIÁ VÉ </a>
                            <a href="#">ƯU ĐÃI </a>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-lg-10 offset-lg-2 footer-mid">
                            <a href="/cus-about-us">GIỚI THIỆU </a>


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
            <script src="/js/product.js" defer></script>
        </body>

        </html>