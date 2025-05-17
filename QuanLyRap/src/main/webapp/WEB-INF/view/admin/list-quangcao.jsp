<!-- filepath: d:\Luyen Mai Thanh Tai\CNPM\QuanLyRap\QuanLyRap\src\main\webapp\WEB-INF\view\admin\list-quangcao.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Danh sách Quảng Cáo</title>
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
                        </div></a>
                        <div><a href="/admin/quangcao" style="color:#5AC5FF;"><img
                                    src="/img/percent-icon.png">&nbsp;KHUYẾN MÃI</a></div>
                    </div>
                </div>
                <div class="col-lg-10 right">
                    <div class="list-phim">
                        <h1 style="margin: 5vh 0;">Danh sách Quảng Cáo</h1>
                        <a href="/admin/quangcao/create">Thêm Quảng Cáo</a>
                        <div style="padding-top: 15px;"></div>
                        <table border="1">
                            <tr>
                                <th>ID</th>
                                <th>Tên Quảng Cáo</th>
                                <th>Số lượng giảm</th>
                                <th>Xóa</th>
                            </tr>
                            <c:forEach var="qc" items="${quangcaos}">
                                <tr>
                                    <td>${qc.idqc}</td>
                                    <td>${qc.tenqc}</td>
                                    <td>${qc.slgiam}</td>
                                    <td>
                                        <a href="/admin/quangcao/delete/${qc.idqc}"
                                            onclick="return confirm('Xóa quảng cáo này?')">Xóa</a>
                                    </td>
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