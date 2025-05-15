<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <html lang="en">

        <head>
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
                        <div><img src="/img/percent-icon.png">&nbsp;KHUYẾN MÃI</div>
                    </div>
                </div>
                <div class="col-lg-10 right">
                    <div class="create-phim">
                        <h2>Chỉnh sửa Phim</h2>
                        <form:form action="/admin/phim/update" modelAttribute="phim" method="post">
                            <form:hidden path="idPhim" />
                            <span>Tên phim:</span>
                            <form:input path="tenPhim" /><br />
                            <span>Nội dung:</span>
                            <form:textarea path="noiDung" /><br />
                            <span>Thời lượng (phút):</span>
                            <form:input path="thoiLuong" type="number" /><br />
                            <span>Ngày chiếu:</span>
                            <form:input path="ngayChieu" type="date" /><br />
                            <span>Đạo diễn:</span>
                            <form:input path="daoDien" /><br />
                            <span>Diễn viên:</span>
                            <form:input path="dienVien" /><br />
                            <span>Ngôn ngữ:</span>
                            <form:input path="ngonNgu" /><br />
                            <span>Thể Loại:</span>
                            <input type="text" name="tenTheLoai" value="${phim.theLoai.tenTheLoai}" /><br />
                            <input type="submit" value="Lưu" />
                        </form:form>
                        <a href="/admin/phim">Về danh sách</a>
                    </div>
                </div>
                <div class="help"><img src="/img/circle-question-regular.png">&nbsp;Trợ giúp</div>
            </div>


            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        </body>

        </html>