window.addEventListener('load', function () {
    let movieData = [
        {
            id: 1,
            name: "THÁM TỬ KIÊN: KỲ ÁN KHÔNG ĐẦU",
            genre: "Kinh dị",
            time: "131",
            start: "30/04/2025",
            director: "Victor Vũ",
            actor: "Quốc Huy, Đinh Ngọc Diệp, Quốc Anh, Minh Anh, Anh Phạm",
            lang: "Tiếng Việt - Phụ đề Tiếng Anh",
            description: "Thám Tử Kiên là một nhân vật được yêu thích trong tác phẩm điện của ăn khách của NGƯỜI VỢ CUỐI CÙNG của Victor Vũ, Thám Tử Kiên: Kỳ Không Đầu sẽ là một phim Victor Vũ trở về với thể loại sở trường Kinh Dị - Trinh Thám sau những tác phẩm tình cảm lãng mạn trước đó.",
            screen: [{
                "27/04/2025": [{
                    screenLang: "2D PHỤ ĐỀ / SUB",
                    time: ["16:35", "17:15", "18:55", "20:20", "21:25", "22:40", "23:35"]
                }],
                "28/04/2025": [{
                    screenLang: "2D PHỤ ĐỀ / SUB",
                    time: ["11:10", "12:00", "18:55", "13:30", "21:25", "22:40", "23:35"]
                }],
                "29/04/2025": [{
                    screenLang: "2D PHỤ ĐỀ / SUB",
                    time: ["10:00", "12:00", "18:55", "13:30", "21:25", "22:40", "23:35"]
                }],
            }]
        },
        {
            id: 2,
            name: "TÌM XÁC: MA KHÔNG ĐẦU",
            genre: "Thriller",
        },
        {
            id: 3,
            name: "ĐỊA ĐẠO: MẶT TRỜI TRONG BÓNG TỐI",
            genre: "Thriller",
        },
    ];
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
            document.getElementById("description").textContent = movieData[i].description;
            document.getElementById("movie-screening-name").textContent = movieData[i].name;
            output += `
                <img class="movie-img" src="./img/product-banner/${movieData[i].id}.png"></img>
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
                        vimg.src = "./img/v.png";
                        langElem.prepend(vimg);

                        const timeElem = document.createElement("div");
                        timeElem.className = "time";
                        show.time.forEach(t => {
                            const link = document.createElement("a");
                            link.href = `./pick-chair.html?name=${movieData[i].name}&date=${encodeURIComponent(date)}&showtime=${t}`;
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



})






