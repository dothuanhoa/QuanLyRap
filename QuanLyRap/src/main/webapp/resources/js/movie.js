window.addEventListener('load', function () {
    product = [
        {
            id: 1,
            name: "THÁM TỬ KIÊN: KỲ ÁN KHÔNG ĐẦU",
            genre: "Thriller",
            showtime: "10h00"
        },
        {
            id: 2,
            name: "TÌM XÁC: MA KHÔNG ĐẦU",
            genre: "Thriller",
            showtime: "10h00"
        },
        {
            id: 3,
            name: "ĐỊA ĐẠO: MẶT TRỜI TRONG BÓNG TỐI",
            genre: "Thriller",
            showtime: "10h00"
        },
        {
            id: 3,
            name: "ĐỊA ĐẠO: MẶT TRỜI TRONG BÓNG TỐI",
            genre: "Thriller",
            showtime: "10h00"
        },
        {
            id: 3,
            name: "ĐỊA ĐẠO: MẶT TRỜI TRONG BÓNG TỐI",
            genre: "Thriller",
            showtime: "10h00"
        },

    ];
    function displayProducts(product) {
        let output = "";
        for (let i in product) {
            const productCard = document.createElement('div');
            /*productCard.classList.add('product-card');*/
            output += `
                <div class="col-lg-3 pb-4">
                    <div class="movie-card" data-id="${product[i].id}">
                        <a href="/product?movie=${product[i].id}"><img src="/img/product/movie${Number(product[i].id)}.png"></a>
                        <div class="movie-tags my-2">
                            <span class="badge bg-danger">T16</span>
                            <span class="badge bg-warning text-dark">Phụ đề</span>
                            <span class="badge bg-info">2D</span>
                        </div>
                        <a href="#">
                            <h4 id="movie-name">${product[i].name}</h4>
                        </a>
                        <div class="movie-category">Thể loại phim: <span>${product[i].genre}</span></div>
                    </div>
                    <div class="buy-now">
                        <a href="/pick-chair?phim=${product[i].id}&showtime=${product[i].showtime}"><img src=/img/ticket.png>&nbsp;&nbsp;MUA VÉ NGAY</a>
                    </div>
                </div>
            `;
        }
        document.getElementById('product-container').innerHTML = output;
    }
    displayProducts(product);
})  