window.addEventListener('load', function () {
    product = [];
    let colorNow = 0;
    let categoryNow = "";

    function displayProducts(product, category) {
        let output = "";
        for (let i in product) {
            if (product[i].category == category || category == 'all') {

                let x = '', y = '', z = '', y1 = 0, z1 = 0;
                if (product[i].color == "green") {
                    x = 'checked';
                }
                else if (product[i].color == "yellow") {
                    y = 'checked';
                    y1 = product[i].price + product[i].price * 0.2;
                    product[i].price = y1.toFixed(2);
                }
                else if (product[i].color == "blue") {
                    z = 'checked';
                    z1 = product[i].price + product[i].price * 0.1;
                    product[i].price = z1.toFixed(2);
                }
                const productCard = document.createElement('div');
                productCard.classList.add('product-card');
                output += `
                <div class="col-lg-3 col-12 product product-show">
                    <div class="card border-0">
                        <img class="card-img-top" src="img/product/product-${Number(product[i].img)}-${(product[i].color)}.jpg" alt="card-pic">
                        <div class="card-img-overlay" data-id="${product[i].id}" data-category="${product[i].category}" data-color="${product[i].color}" data-name="${product[i].name}" data-price="${product[i].price}" data-img="${product[i].img}">
                            <span class="tag">NEW</span>
                            <div class="card-hover">
                                <li><a href="#"><img src="img/icon/heart.png" class="icon"></a></li>
                                <li><a href="#"><img src="img/icon/compare.png" class="icon">
                                        <span>Compare</span><i class="bi bi-caret-right-fill"></i></a>
                                </li>
                                <li><a href="#"><img src="img/icon/search.png" class="icon"></a></li>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="product-text">
                            <h6>${product[i].name}</h6>
                            <a href="#" class="add"  data-bs-toggle="modal" data-bs-target="#staticBackdrop" 
                                data-id="${product[i].id}" data-name="${product[i].name}" data-price="${product[i].price}" 
                                data-img="${product[i].img}" data-color='${(product[i].color)}'>+Add To Cart
                            </a>
                        </div>
                        <div class="rating">
                            <i class="bi bi-star-fill"></i>
                            <i class="bi bi-star"></i>
                            <i class="bi bi-star"></i>
                            <i class="bi bi-star"></i>
                            <i class="bi bi-star"></i>
                        </div>
                        <h5>$${product[i].price}</h5>
                        <div class="product-color">
                            <div class="form-check form-check-inline blue-radio">
                                <input class="form-check-input" name="radio${product[i].id}" data-id='${product[i].id}' data-color="blue" type="radio" id="pc-1" ${z}>
                                <label class="form-check-label" for="pc-1"></label>
                            </div>
                            <div class="form-check form-check-inline green-radio">
                                <input class="form-check-input" name="radio${product[i].id}" data-id='${product[i].id}' data-color="green" type="radio" id="pc-2" ${x}>
                                <label class="form-check-label green" for="pc-2"></label>
                            </div>
                            <div class="form-check form-check-inline yellow-radio">
                                <input class="form-check-input" name="radio${product[i].id}" data-id='${product[i].id}' data-color="yellow" type="radio" id="pc-3" ${y}>
                                <label class="form-check-label yellow" for="pc-3"></label>
                            </div>
                        </div>
                    </div>
                </div>
            `;
            }
        }
        document.getElementById('product-container').innerHTML = output;
    }

    async function fetchProducts(category) {
        let apiUrl = 'http://localhost:3000/products';
        const response = await fetch(apiUrl)
        product = await response.json();
        displayProducts(product, category);
        console.log(product);
        categoryNow = category;
    }

    function active(a) {
        let btns = document.getElementsByClassName("product-choice");
        let current = document.getElementsByClassName("product-active");
        current[0].className = current[0].className.replace(" product-active", "");
        btns[a].className += " product-active";
        colorNow = a;
    }

    document.getElementById("product-1").addEventListener("click", function () { fetchProducts("all"), active(0) });
    document.getElementById("product-2").addEventListener("click", function () { fetchProducts("product-arrivals"), active(1) });
    document.getElementById("product-3").addEventListener("click", function () { fetchProducts("product-hotSales"), active(2) });

    fetchProducts('all');

    function changeColor(id, color) {
        fetch(`http://localhost:3000/products/${id}%20${color}`)
            .then(res => res.json())
            .then(json => {
                console.log(json);
                product = json;
                fetchProducts(categoryNow);
                active(colorNow);
            })
    }

    document.querySelectorAll('.product-item').forEach(element => {
        element.addEventListener('change', function (event) {
            if (event.target.classList.contains('form-check-input')) {
                event.preventDefault();
                let color = event.target.dataset.color;
                let id = event.target.dataset.id;
                changeColor(id, color);
            };
        })
    });

    const targetDate = new Date('January 28, 2026 00:00:00').getTime();
    const countdownInterval = setInterval(() => {
        const now = new Date().getTime();
        const timeDifference = targetDate - now;
        const days = Math.floor(timeDifference / (1000 * 60 * 60 * 24));
        const hours = Math.floor((timeDifference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        const minutes = Math.floor((timeDifference % (1000 * 60 * 60)) / (1000 * 60));
        const seconds = Math.floor((timeDifference % (1000 * 60)) / 1000);
        document.getElementById('Days').innerHTML = days;
        document.getElementById('Hours').innerHTML = hours;
        document.getElementById('Minutes').innerHTML = minutes;
        document.getElementById('Seconds').innerHTML = seconds;
        if (timeDifference < 0) {
            clearInterval(countdownInterval);
        }
    })
})  