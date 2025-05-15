window.addEventListener('load', function () {
    fetch('/api/movies')
        .then(response => response.json())
        .then(data => {
            let movieData = data.map(movie => ({
                id: movie.idPhim,
                name: movie.tenPhim,
                genre: movie.theLoai.tenTheLoai,
                time: movie.ngayChieu,
                director: movie.daoDien,
                actor: movie.dienVien,
                lang: movie.ngonNgu,
                content: movie.noiDung,
                screen: movie.lichChieuList.map(lichChieu => ({
                    [lichChieu.ngayChieu]: lichChieu.suatChieuList.map(suatChieu => ({
                        time: suatChieu.thoiGianBatDau
                    }))
                }))
            }));

            console.log(movieData); // Kiểm tra dữ liệu
            displayMovies(movieData);
        })
        .catch(error => console.error('Error fetching movies:', error));
});

function displayMovies(movieData) {
    const urlParams = new URLSearchParams(window.location.search);
    const movieID = urlParams.get('movie') || "1";
    let output = "";
    for (let i in movieData) {
        if (movieData[i].id == movieID) {
            document.getElementById("movie").textContent = movieData[i].name;
            document.getElementById("genre").textContent = movieData[i].genre;
            document.getElementById("time").textContent = movieData[i].time + " phút";
            document.getElementById("start").textContent = movieData[i].start;
            document.getElementById("director").textContent = movieData[i].director;
            document.getElementById("actor").textContent = movieData[i].actor + ",...";
            document.getElementById("lang").textContent = movieData[i].lang;
            document.getElementById("content").textContent = movieData[i].content;
            document.getElementById("movie-screening-name").textContent = movieData[i].name;
            output += `
                <img class="movie-img" src="/img/product-banner/${movieData[i].id}.png"></img>
            `;
            const container = document.getElementById("movie-screening");

            movieData[i].screen.forEach(scheduleObj => {
                for (const [date, shows] of Object.entries(scheduleObj)) {
                    const dateElem = document.createElement("div");
                    dateElem.className = "date";
                    dateElem.textContent = `Ngày ${date}`;
                    container.appendChild(dateElem);

                    shows.forEach(show => {
                        const langElem = document.createElement("div");
                        langElem.className = "screenLang";
                        langElem.textContent = show.screenLang;
                        container.appendChild(langElem);

                        const vimg = document.createElement("img");
                        vimg.src = "/img/v.png";
                        langElem.prepend(vimg);

                        const timeElem = document.createElement("div");
                        timeElem.className = "time";
                        show.time.forEach(t => {
                            const link = document.createElement("a");
                            link.href = `/customer/${khachHang.idkh}/cus-pick-chair?name=${movieData[i].name}&date=${encodeURIComponent(date)}&showtime=${t}`;
                            link.textContent = t;
                            link.className = "time-link";
                            link.style.textDecoration = "none";

                            const timeBox = document.createElement("span");
                            timeBox.textContent = t;
                            timeBox.style.pointerEvents = "none"; // Để span không ngăn click
                            link.innerHTML = "";
                            link.appendChild(timeBox);
                            timeElem.appendChild(link);
                        });
                        container.appendChild(timeElem);
                    });
                }
            });
        }
    }
    document.getElementById('movie-img').innerHTML = output;
}






