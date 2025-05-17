<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html lang="en">

        <head>
            <meta charset="UTF__8">
            <title>Ocean Cinema</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
            <link rel="stylesheet" href="/css/admin.css" type="text/css">
            <link rel="stylesheet" href="/css/list-phim.css" type="text/css">
            <style>
                .right {
                    display: flex;
                    align-items: start;
                    justify-content: left;
                }

                td {
                    padding: 15px;
                }
            </style>
        </head>

        <body>
            <div class="row main">
                <div class="col-lg-2 left">
                    <div class="oceancinema">OCEAN CINEMA</div>
                    <div class="movie">
                        <div><a href="/admin/phim" style="color:#5AC5FF;"><img src="/img/movie-icon.png">&nbsp;PHIM
                            </a></div>
                        <div><a href="/admin/quangcao" style="color:#5AC5FF;"><img
                                    src="/img/percent-icon.png">&nbsp;KHUYẾN MÃI</a></div>
                    </div>
                </div>
                <div class="col-lg-10 right">
                    <div class="list-phim">
                        <h1 style="margin: 5vh 0;">Danh sách phim</h1>

                        <!-- Error message display -->
                        <c:if test="${not empty errorMessage}">
                            <div class="alert alert-danger" role="alert">
                                ${errorMessage}
                            </div>
                        </c:if>

                        <a href="/admin/phim/create">Tạo phim mới</a>
                        <p style="font-size: 15px; margin-top: 15px;">Với hình ảnh của phim quản lý hãy tự thêm vào thư
                            mục
                            img/product với tên là movie+id phim (ví dụ: movie1.png) và
                            img/product-banner với tên là id phim (ví dụ: 1.png)</p>
                        <table border="1" style="margin: 2vh 0 0.7vh 0; text-align: center;">
                            <tr>
                                <th>ID</th>
                                <th>Tên phim</th>
                                <th>Sửa</th>
                                <th>Xóa</th>
                            </tr>
                            <c:forEach var="phim" items="${phims}">
                                <tr>
                                    <td>${phim.idPhim}</td>
                                    <td>${phim.tenPhim}</td>
                                    <td><a href="/admin/phim/edit/${phim.idPhim}">Sửa</a></td>
                                    <td><a href="/admin/phim/delete/${phim.idPhim}"
                                            onclick="return confirm('Xóa phim này?')">Xóa</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="help"><img src="/img/circle-question-regular.png">&nbsp;Trợ giúp</div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        </body>

        </html>