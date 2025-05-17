<!-- filepath: d:\Luyen Mai Thanh Tai\CNPM\QuanLyRap\QuanLyRap\src\main\webapp\WEB-INF\view\admin\create-quangcao.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <html>

        <head>
            <title>Thêm Quảng Cáo</title>
            <meta charset="UTF__8">
            <title>Ocean Cinema</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
            <link rel="stylesheet" href="/css/admin.css" type="text/css">
            <style>
                .right {
                    display: flex;
                    align-items: start;
                    justify-content: left;
                }

                .create-phim {
                    padding: 10vh;
                }

                input {
                    padding: 10px 20px;
                    width: 100%;
                    max-width: 100%;
                    box-sizing: border-box;
                }

                input[type="submit"] {
                    padding: 5px 20px;
                    min-width: 10vw;
                    width: 10vw;
                }

                span {
                    line-height: 48px;
                    min-width: 30vw;
                }

                .create-phim a {
                    color: black;
                    text-decoration: underline;
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
                    <div class="create-phim">
                        <h2>Thêm Quảng Cáo</h2>
                        <form:form method="post" action="/admin/quangcao/save" modelAttribute="quangCao">
                            <div>
                                <label>Tên Quảng Cáo:</label>
                                <form:input path="tenqc" />
                            </div>
                            <div>
                                <label>Số lượng giảm:</label>
                                <form:input path="slgiam" type="number" />
                            </div>
                            <button type="submit">Lưu</button>
                        </form:form>
                        <a href="/admin/quangcao">Quay lại</a>
                    </div>
                </div>
                <div class="help"><img src="/img/circle-question-regular.png">&nbsp;Trợ giúp</div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        </body>

        </html>