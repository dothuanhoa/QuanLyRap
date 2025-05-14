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
            </style>
        </head>

        <body>
            <div class="row main">
                <div class="col-lg-2 left">
                    <div class="oceancinema">OCEAN CINEMA</div>
                    <div class="movie">
                        <div><a href="movie-interface.html" style="color:#5AC5FF;"><img
                                    src="./img/movie-icon.png">&nbsp;PHIM</div></a>
                        <div><img src="./img/percent-icon.png">&nbsp;KHUYẾN MÃI</div>
                    </div>
                </div>
                <div class="col-lg-10 right">
                    <div class="list-phim">
                        <h1 style="margin: 5vh 0;">Danh sách phim</h1>
                        <a href="/admin/phim/create">Tạo phim mới</a>
                        <table border="1" style="margin: 2vh 0 0.7vh 0;">
                            <tr>
                                <th>ID</th>
                                <th>Tên phim</th>
                            </tr>
                            <c:forEach var="phim" items="${phims}">
                                <tr>
                                    <td>${phim.idPhim}</td>
                                    <td>${phim.tenPhim}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <div class="end">
                            <a href="/admin/phim/edit/${phim.idPhim}">Sửa</a>
                            <a href="/admin/phim/delete/${phim.idPhim}"
                                onclick="return confirm('Xóa phim này?')">Xóa</a>
                        </div>
                    </div>
                </div>
                <div class="help"><img src="./img/circle-question-regular.png">&nbsp;Trợ giúp</div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        </body>

        </html>