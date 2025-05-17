<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
                <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                    <html lang="en">

                    <head>
                        <meta charset="UTF-8">
                        <title>Cập nhật thông tin cá nhân</title>
                        <link rel="stylesheet" href="/css/registered.css" type="text/css">
                        <style>
                            .booking-history {
                                margin-top: 30px;
                                padding: 20px;
                            }

                            .table {
                                width: 100%;
                                border-collapse: collapse;
                                margin-top: 20px;
                            }

                            .table th,
                            .table td {
                                padding: 12px;
                                text-align: left;
                                border-bottom: 1px solid #ddd;
                            }

                            .table th {
                                background-color: #f5f5f5;
                                font-weight: bold;
                            }

                            .table tr:hover {
                                background-color: #f9f9f9;
                            }
                        </style>
                    </head>

                    <body>
                        <div class="main">
                            <h2>Cập nhật thông tin cá nhân</h2>
                            <form:form method="post" action="/customer/update-profile" modelAttribute="khachHang">
                                <form:hidden path="idkh" />
                                <div>
                                    <label>Mật khẩu:</label>
                                    <form:password path="matkhau" />
                                </div>
                                <div>
                                    <label>Tên:</label>
                                    <form:input path="tenkh" />
                                </div>
                                <div>
                                    <label>Họ:</label>
                                    <form:input path="ho" />
                                </div>
                                <div>
                                    <label>Ngày sinh:</label>
                                    <form:input path="ngaysinh" type="date" />
                                </div>
                                <div>
                                    <label>Giới tính:</label>
                                    <form:select path="gioitinh">
                                        <form:option value="true">Nam</form:option>
                                        <form:option value="false">Nữ</form:option>
                                    </form:select>
                                </div>
                                <div>
                                    <label>Số điện thoại:</label>
                                    <form:input path="sdt" />
                                </div>
                                <button type="submit">Cập nhật</button>

                                <c:if test="${not empty error}">
                                    <p style="color:red">${error}</p>
                                </c:if>
                                <c:if test="${not empty success}">
                                    <p style="color:green">${success}</p>
                                </c:if>
                            </form:form>
                            <a style="border: 1px solid black; text-decoration: none; border-radius: 20px; padding: 10px;"
                                href="/customer/${khachHang.idkh}">Back</a>
                        </div>

                        <div class="booking-history">
                            <h3>Lịch sử đặt vé</h3>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>ID Hóa đơn</th>
                                        <th>Tên phim</th>
                                        <th>Phòng chiếu</th>
                                        <th>Ghế đã đặt</th>
                                        <th>Tổng tiền</th>
                                        <th>Thời gian chiếu</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="hoaDon" items="${hoaDonList}">
                                        <tr>
                                            <td>${hoaDon.idhoadon}</td>
                                            <td>
                                                ${fn:trim(fn:substringBefore(fn:substringAfter(hoaDon.ghiChu, "Phim: "),
                                                ", Suất"))}
                                            </td>
                                            <td>
                                                ${fn:trim(fn:substringBefore(fn:substringAfter(hoaDon.ghiChu, "Phòng:
                                                "), ", Phim:"))}

                                            </td>
                                            <td>
                                                ${fn:trim(fn:substringAfter(hoaDon.ghiChu, "Ghế: "))}
                                            </td>
                                            <td>
                                                <fmt:formatNumber value="${hoaDon.tongtien}" type="currency"
                                                    currencySymbol="VNĐ" />
                                            </td>
                                            <td>
                                                ${fn:trim(fn:substringBefore(fn:substringAfter(hoaDon.ghiChu, "Suất: "),
                                                ", Ngày"))}
                                                -
                                                ${fn:trim(fn:substringBefore(fn:substringAfter(hoaDon.ghiChu, "Ngày: "),
                                                ", Ghế"))}
                                            </td>
                                        </tr>



                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </body>

                    </html>