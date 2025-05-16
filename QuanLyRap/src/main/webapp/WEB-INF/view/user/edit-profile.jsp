<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cập nhật thông tin cá nhân</title>
    <link rel="stylesheet" href="/css/registered.css" type="text/css">
</head>
<body>
    <div class="main">
        <h2>Cập nhật thông tin cá nhân</h2>
        <form:form method="post" action="/customer/update-profile" modelAttribute="khachHang">
            <form:hidden path="idkh"/>
            <div>
                <label>Mật khẩu:</label>
                <form:password path="matkhau"/>
            </div>
            <div>
                <label>Tên:</label>
                <form:input path="tenkh"/>
            </div>
            <div>
                <label>Họ:</label>
                <form:input path="ho"/>
            </div>
            <div>
                <label>Ngày sinh:</label>
                <form:input path="ngaysinh" type="date"/>
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
                <form:input path="sdt"/>
            </div>
            <button type="submit">Cập nhật</button>

            <c:if test="${not empty error}">
                <p style="color:red">${error}</p>
            </c:if>
            <c:if test="${not empty success}">
                <p style="color:green">${success}</p>
            </c:if>
        </form:form>
        <a style="border: 1px solid black; text-decoration: none; border-radius: 20px; padding: 10px;" href="/customer/${khachHang.idkh}">Back</a>
    </div>
</body>
</html>