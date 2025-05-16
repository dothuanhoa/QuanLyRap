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
            <link rel="stylesheet" href="/css/pick-chair.css" type="text/css">
            <script src="https://cdn.tailwindcss.com"></script>
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

            <div class="main">
                <div class="session">
                    <h1>1</h1><span>CHỌN VỊ TRÍ -</span><span id="name"></span>
                </div>
                <div class="pick-chair-container mb-4">
                    <div class="bg-blue-200 p-6 font-sans" style="width: 70%;">
                        <h1 class="text-2xl font-bold mb-4">Đặt vé - Suất chiếu: <span id="showtime"
                                class="text-blue-600"></span></h1>
                        <!-- Ghi chú -->
                        <div class="mt-6 space-y-1 text-sm text-gray-800 mb-2 chair">
                            <div class="flex gap-2 items-center">
                                <div class="w-5 h-5 bg-black rounded-sm"></div> Ghế của bạn
                            </div>
                            <div class="flex gap-2 items-center">
                                <div class="w-5 h-5 bg-white border border-black rounded-sm"></div> Khu vực Standard
                            </div>
                            <div class="flex gap-2 items-center">
                                <div class="w-5 h-5 bg-red-600 rounded-sm"></div> Ghế đã bán
                            </div>
                        </div>
                        <div class="chair-note">(*) Chỉ được chọn tối đa 10 ghế 1 lần</div>
                        <div id="seat-map" class="flex flex-col gap-1 mb-4"></div>
                        <!-- Modal -->
                        <div id="modal"
                            class="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 hidden">
                            <div class="bg-white p-6 rounded-xl shadow-lg text-center">
                                <p id="modal-text" class="mb-4 text-lg"></p>
                                <button id="confirm-btn" class="bg-blue-500 text-white px-4 py-2 rounded mr-2">Xác
                                    nhận</button>
                                <button id="cancel-btn" class="bg-gray-300 px-4 py-2 rounded">Hủy</button>
                            </div>
                        </div>
                        <div class="bottom-note">Click vào ghế đang chọn (màu đen) để hủy chọn nếu bạn muốn chọn ghế
                            khác.<br />
                            Xin lưu ý rằng hệ thống không cho phép bạn để một ghế trống đơn lẻ giữa các ghế được chọn.
                        </div>
                    </div>
                </div>
                <div class="cash-out row">
                    <div class="cash-out-left col-lg-6">
                        <div class="session">
                            <h1>2</h1><span>THÔNG TIN THANH TOÁN</span>
                        </div>
                        <input type="fullname" id="fullname" placeholder="Họ Tên"><br />
                        <input type="email" id="email" placeholder="Email"><br />
                        <input type="phone" id="repassword" placeholder="Số điện thoại">
                        <div class="price">Thành tiền:&nbsp;<span id="price"></span></div>
                    </div>
                    <div class="cash-out-right col-lg-6">
                        <div class="payment-title">PHƯƠNG THỨC THANH TOÁN</div>
                        <label class="payment-option">
                            <img src="/img/momo.png" alt="MoMo" />
                            <span>Chỉ nhận thanh toán MoMo</span>
                        </label>
                        <label class="terms">
                            <input type="checkbox" />
                            <span>Tôi đã đọc và đồng ý với Chính sách thanh toán vé trực tuyến</span>
                        </label>
                        <div class="note">
                            (*) Vé đã mua không thể đổi hoặc hoàn tiền. <br />
                            Mã vé sẽ được gửi qua Email đã nhập.
                        </div>
                    </div>
                </div>
                <div class="last-step">
                    <h1>(*) Đăng nhập để được tích điểm thưởng</h1>
                    <div div class="button-container">
                        <a class="decline">Hủy đặt vé</a>
                        <button id="confirm-btn" class="buy">Thanh toán</button>
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
            <script src="/js/pick-chair.js" defer></script>
        </body>

        </html>