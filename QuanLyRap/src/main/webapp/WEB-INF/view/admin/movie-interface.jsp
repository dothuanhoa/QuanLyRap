<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html lang="en">

        <head>
            <meta charset="UTF__8">
            <title>Ocean Cinema</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
            <link rel="stylesheet" href="/css/admin.css" type="text/css">
            <link rel="stylesheet" href="/css/movie-interface.css" type="text/css">
        </head>

        <body>
            <div class="row">
                <div class="col-lg-2 left">
                    <div class="oceancinema">OCEAN CINEMA</div>
                    <div class="movie">
                        <div class=""><img src="/img/movie-icon.png">&nbsp;PHIM</div>
                        <div class=""><img src="/img/percent-icon.png">&nbsp;KHUYẾN MÃI</div>
                    </div>
                </div>
                <div class="col-lg-10 right">
                    <div class="container">
                        <div class="search-bar">
                            <label for="search">Tìm phim</label>
                            <input type="text" id="search" placeholder="Nhập tên phim..." />
                            <button onclick="searchPhim()">🔍</button>
                        </div>

                        <table>
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="checkAll" onclick="toggleAll(this)" /> ALL</th>
                                    <th>IDPHIM</th>
                                    <th>TENPHIM</th>
                                </tr>
                            </thead>
                            <tbody id="phimList">
                                <tr>
                                    <td><input type="checkbox" class="row-check" /></td>
                                    <td>fasdfasdf</td>
                                    <td>fasdfasdfasdfasd</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="row-check" /></td>
                                    <td>fasdfasdf</td>
                                    <td>fasdfasdfasdfasd</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="row-check" /></td>
                                    <td>fasdfasdf</td>
                                    <td>fasdfasdfasdfasd</td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="row-limit">
                            <label>Hiển thị:</label>
                            <a href="" onclick="setRowLimit(3),handleClick(event)">3</a>
                            <a href="" onclick="setRowLimit(10),handleClick(event)">10</a>
                            <a href="" onclick="setRowLimit(20),handleClick(event)">20</a>
                            <a href="" onclick="setRowLimit(30),handleClick(event)">30</a>
                            <a href="" onclick="setRowLimit('all'),handleClick(event)">All</a>
                        </div>
                        <div class="buttons">
                            <button onclick="themPhim()">Thêm phim</button>
                            <button class="red" onclick="xoaPhim()">Xóa phim</button>
                        </div>


                    </div>
                </div>
                <div class="help"><img src="/img/circle-question-regular.png">&nbsp;Trợ giúp</div>
            </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            <script src="/js/movie-interface.js"></script>
        </body>

        </html>