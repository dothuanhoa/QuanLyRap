window.addEventListener('load', function () {
    cart = [];
    function Item(id, name, price, count, img, color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.img = img;
        this.color = color;
    }
    function shop(id, name, priceGreen, priceBlue, priceYellow, countGreen, countBlue, countYellow, img, color) {
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
    const tam = {
        id: 999,
        name: 'tam',
        price: 1,
        count: 1,
        img: 1,
        color: 'green'
    }
    async function fetchProducts(item) {
        let apiUrl = 'http://localhost:3000/cart/add';
        const response = await fetch(apiUrl, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(item)
        })
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        cart = await response.json();
        console.log("Product added to cart:", cart);
        displayCart();
    }
    async function removeFromCart(id, color) {
        const response = await fetch(`http://localhost:3000/cart/${id}%20${color}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
            },
        });
        cart = await response.json();
        console.log("Product removed from cart:", cart);
        displayCart();
    }

    function changeCountCart(id, count, color) {
        fetch(`http://localhost:3000/cart/${id}%20${count}%20${color}`)
            .then(res => res.json())
            .then(json => {
                console.log(json),
                    cart = json,
                    displayCart()
            })
    }

    function clearCart() {
        fetch(`http://localhost:3000/cart/clear`)
            .then(res => res.json())
            .then(json => {
                console.log(json),
                    cart = json,
                    displayCart()
            })
    }

    async function openProduct(item) {
        let apiUrl = 'http://localhost:3000/shop/add';
        const response = await fetch(apiUrl, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(item)
        })
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        window.location.href = 'shop.html';
    }

    function displayCart() {
        let x = 0;
        let y = 0;
        let output = "";
        for (let i in cart) {
            let z = (cart[i].price * cart[i].count).toFixed(2);
            output += "<tr>"
                + "<td class='cart-price'><img src='img/product/product-" + cart[i].img + "-" + cart[i].color + ".jpg'>"
                + "<div><span>" + cart[i].name + "</span><span>$" + cart[i].price + "</span></div></td>"
                + "<td><div class='input-group'>"
                + "<input type='number' class='item-count form-control' data-id='" + cart[i].id + "' data-color='" + cart[i].color + "' data-name='" + cart[i].name + "' value='" + cart[i].count + "'>"
                + "</div></td>"
                + "<td class='cart-price'>$" + z + "</td>"
                + "<td><button class='delete-item'  data-id='" + cart[i].id + "' data-color='" + cart[i].color + "' data-name='" + cart[i].name + "'>X</button></td>"
                + "</tr>";
            x += cart[i].count;
            y += cart[i].price * Number(cart[i].count);
        }
        document.querySelectorAll('.count').forEach(element => {
            element.innerHTML = x;
        });
        document.querySelectorAll('.price').forEach(element => {
            element.innerHTML = "$" + y.toFixed(2);
        });
        document.querySelectorAll('.show-cart').forEach(element => {
            element.innerHTML = output;
        });
    };
    fetchProducts(tam);

    document.querySelectorAll('.product-item').forEach(element => {
        element.addEventListener('click', function (event) {
            if (event.target.classList.contains('add')) {
                event.preventDefault();
                let id = event.target.dataset.id;
                let name = event.target.dataset.name;
                let price = event.target.dataset.price;
                let img = event.target.dataset.img;
                let count = 1;
                let color = event.target.dataset.color;
                let item = new Item(id, name, price, count, img, color);
                fetchProducts(item);
            };
        })
    });

    document.querySelectorAll('.show-cart').forEach(element => {
        element.addEventListener('click', function (event) {
            if (event.target.classList.contains('delete-item')) {
                let id = event.target.dataset.id;
                let color = event.target.dataset.color;
                removeFromCart(id, color);
            }
        })
    });

    document.querySelectorAll('.show-cart').forEach(element => {
        element.addEventListener('change', function (event) {
            if (event.target.classList.contains('item-count')) {
                let id = event.target.dataset.id;
                let color = event.target.dataset.color;
                let count = Number(event.target.value);
                changeCountCart(id, count, color);
            }
        })
    });

    document.querySelectorAll('.shop').forEach(element => {
        element.addEventListener('change', function (event) {
            if (event.target.classList.contains('item-count')) {
                event.preventDefault();
                let id = event.target.dataset.id;
                let name = event.target.dataset.name;
                let color = event.target.dataset.color;
                let count = Number(event.target.value);
                let img = event.target.dataset.img;
                let flag = true;
                for (let i in cart) {
                    if (cart[i].id == id && cart[i].color == color) {
                        flag = false;
                    }
                }
                if (flag == true) {
                    let item = new Item(id, name, price, count, img, color);
                    fetchProducts(item)
                }

                changeCountCart(id, count, color);
            };
        })
    });

    document.querySelectorAll('.product-item').forEach(element => {
        element.addEventListener('click', function (event) {
            if (event.target.classList.contains('card-img-overlay')) {
                event.preventDefault();
                let id = event.target.dataset.id;
                let name = event.target.dataset.name;
                let price = event.target.dataset.price;
                let priceGreen = 0;
                let priceYellow = 0;
                let priceBlue = 0;
                let img = event.target.dataset.img;
                let countGreen = 0;
                let countYellow = 0;
                let countBlue = 0;
                let color = event.target.dataset.color;
                if (cart.length > 0) {
                    for (let i in cart) {
                        if (name == cart[i].name) {
                            if (cart[i].color == 'green') {
                                countGreen = cart[i].count;
                                priceGreen = cart[i].price;
                            }
                            else if (cart[i].color == 'yellow') {
                                priceYellow = cart[i].price;
                                countYellow = cart[i].count;

                            }
                            else if (cart[i].color == 'blue') {
                                priceBlue = cart[i].price;
                                countBlue = cart[i].count;

                            }
                        }
                        else {
                            if (color == 'green') {
                                priceGreen = price;
                                priceBlue = (price * 1.1).toFixed(2);
                                priceYellow = (price * 1.2).toFixed(2);
                            }
                            else if (color == 'blue') {
                                priceBlue = price;
                                priceGreen = (price / 1.1).toFixed(2);
                                priceYellow = (priceGreen * 1.2).toFixed(2);
                            }
                            else if (color == 'yellow') {
                                priceYellow = price;
                                priceGreen = (price / 1.2).toFixed(2);
                                priceBlue = (priceGreen * 1.1).toFixed(2);
                            }
                        }
                    }
                }
                else {
                    if (color == 'green') {
                        priceGreen = price;
                        priceBlue = (price * 1.1).toFixed(2);
                        priceYellow = (price * 1.2).toFixed(2);
                    }
                    else if (color == 'blue') {
                        priceBlue = price;
                        priceGreen = (price / 1.1).toFixed(2);
                        priceYellow = (priceGreen * 1.2).toFixed(2);
                    }
                    else if (color == 'yellow') {
                        priceYellow = price;
                        priceGreen = (price / 1.2).toFixed(2);
                        priceBlue = (priceGreen * 1.1).toFixed(2);
                    }
                }
                let item = new shop(id, name, priceGreen, priceBlue, priceYellow, countGreen, countBlue, countYellow, img, color);
                openProduct(item);
            };
        })
    });


    document.querySelector('.clear-all').addEventListener('click', function (event) {
        clearCart();
    });

    document.getElementById("load").classList.add("changed");
    setTimeout(() => {
        document.getElementById("load").classList.remove("changed");
    }, 200);

    document.querySelectorAll('.search').forEach(element => {
        element.addEventListener('click', function (event) {
            event.preventDefault();
            document.getElementById("search-page").classList.add("changed");
        })
    });

    document.querySelectorAll('.search-out').forEach(element => {
        element.addEventListener('click', function (event) {
            event.preventDefault();
            document.getElementById("search-page").classList.remove("changed");
        })
    });
});
