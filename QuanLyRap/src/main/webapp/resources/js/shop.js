window.addEventListener('load', function () {
    shop = [];
    function item(id, name, priceGreen, priceBlue, priceYellow, countGreen, countBlue, countYellow, img, color) {
        this.id = id;
        this.name = name;
        this.priceGreen = priceGreen;
        this.priceBlue = priceBlue;
        this.priceYellow = priceYellow;
        this.countGreen = countGreen;
        this.countBlue = countBlue;
        this.countYellow = countYellow;
        this.img = img;
        this.color = color;
    }

    async function fetchProducts() {
        let apiUrl = 'http://localhost:3306/shop';
        const response = await fetch(apiUrl)
        shop = await response.json();
        displayProducts();
    }

    function changeCountShop(count, color) {
        fetch(`http://localhost:3000/shop/${count}%20${color}`)
            .then(res => res.json())
            .then(json => {
                console.log(json),
                    shop = json,
                    displayProducts();
            })
    }

    async function removeFromShop(color) {
        const response = await fetch(`http://localhost:3000/shop/${color}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
            },
        });
        shop = await response.json();
        console.log("Product removed from cart:", cart);
        displayProducts();
    }

    function clearShop() {
        fetch(`http://localhost:3000/shop/clear`)
            .then(res => res.json())
            .then(json => {
                console.log(json),
                    shop = json,
                    displayProducts();
            })
    }

    function displayProducts() {
        let output = "";
        let a = 0;
        for (let i in shop) {
            let x = '';
            let y = '';
            let z = '';
            if (shop[i].color == "green") {
                x = 'checked';
                price = shop[i].priceGreen;
                count = shop[i].countGreen;
            }
            else if (shop[i].color == "yellow") {
                y = 'checked';
                price = shop[i].priceYellow;
                count = shop[i].countYellow;
            }
            else if (shop[i].color == "blue") {
                z = 'checked';
                price = shop[i].priceBlue;
                count = shop[i].countBlue;
            }
            const productCard = document.createElement('div');
            productCard.classList.add('product-card');

            output += `
           <div class="row">
            <div class="col-lg-6">
                <img class="product-picture" src="img/product/product-${Number(shop[i].img)}-${shop[i].color}.jpg" alt="card-pic">
            </div>
            <div class="col-lg-4 right">
                <h6>Samsonite</h6>
                <h3>${shop[i].name}</h3>
                <h4>$${price}<span>OnStock</span></h4>
                <div class="shop-rating">
                    <i class="bi bi-star"></i>
                    <i class="bi bi-star"></i>
                    <i class="bi bi-star"></i>
                    <i class="bi bi-star"></i>
                    <i class="bi bi-star"></i>
                </div>
                <div class="color">
                    <div class="form-check form-check-inline blue-radio">
                        <input class="form-check-input" data-color='blue' name="radio1" type="radio" id="pc-1" ${z} min='0'>
                        <label class="form-check-label" for="pc-1"></label>
                    </div>
                    <div class="form-check form-check-inline green-radio">
                        <input class="form-check-input" data-color='green' name="radio1" type="radio" id="pc-2" ${x} min='0'>
                        <label class="form-check-label green" for="pc-2"></label>
                    </div>
                    <div class="form-check form-check-inline yellow-radio">
                        <input class="form-check-input" data-color='yellow' name="radio1" type="radio" id="pc-3" ${y} min='0'>
                        <label class="form-check-label yellow" for="pc-3"></label>
                    </div>
                </div>
                <div class='input-group'><span>Quantity :</span>
                    <input type='number' class='item-count form-control' data-id='${shop[i].id}'
                        data-name='${shop[i].name}' data-img='${shop[i].img}' data-color='${shop[i].color}' value='${count}'>
                </div>
                <div class="shop-cost">Total :<span class='shop-total'></span></div>
                <button type="button" class="btn btn-secondary">Buy Now</button>
            </div>
        `;
            a += price * Number(count);
        }
        document.getElementById('shop').innerHTML = output;
        document.querySelectorAll('.shop-total').forEach(element => {
            element.innerHTML = "$" + a.toFixed(2);
        });
    }

    fetchProducts()

    document.querySelectorAll('.shop').forEach(element => {
        element.addEventListener('change', function (event) {
            if (event.target.classList.contains('form-check-input')) {
                event.preventDefault();
                let color = event.target.dataset.color;
                shop[0].color = color;
                displayProducts();
            };
        })
    });

    document.querySelectorAll('.shop').forEach(element => {
        element.addEventListener('change', function (event) {
            if (event.target.classList.contains('form-check-input')) {
                event.preventDefault();
                let color = event.target.dataset.color;
                shop[0].color = color;
                displayProducts();
            };
        })
    });

    document.querySelectorAll('.shop').forEach(element => {
        element.addEventListener('change', function (event) {
            if (event.target.classList.contains('item-count')) {
                event.preventDefault();
                let color = shop[0].color;
                let count = Number(event.target.value);
                if (count < 0) {
                    count = 0;
                }
                changeCountShop(count, color);
            };
        })
    });

    document.querySelectorAll('.show-cart').forEach(element => {
        element.addEventListener('change', function (event) {
            if (event.target.classList.contains('item-count')) {
                let color = event.target.dataset.color;
                let count = Number(event.target.value);
                changeCountShop(count, color);
            }
        })
    });

    document.querySelectorAll('.show-cart').forEach(element => {
        element.addEventListener('click', function (event) {
            if (event.target.classList.contains('delete-item')) {
                let color = event.target.dataset.color;
                removeFromShop(color);
            }
        })
    });

    document.querySelector('.clear-all').addEventListener('click', function (event) {
        clearShop();
    });

})