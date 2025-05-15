// window.addEventListener('load', function () {
//     fetch('/api/movies')
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error(`HTTP error! status: ${response.status}`);
//             }
//             return response.json();
//         })
//         .then(data => {
//             if (!Array.isArray(data)) {
//                 throw new Error('API did not return an array');
//             }
//             displayProducts(data);
//         })
//         .catch(error => console.error('Error fetching movies:', error));

//     function displayProducts(product) {
//         if (!product || product.length === 0) {
//             console.error('No products to display');
//             return;
//         }
//         let output = "";
//         for (let i in product) {
//             output += `
//                 <div class="col-lg-3 pb-4">
//                     <div class="movie-card" data-id="${product[i].idPhim}">
//                         <a href="/product?movie=${product[i].idPhim}">
//                             <img src="/img/product/movie${Number(product[i].idPhim)}.png" alt="${product[i].tenPhim}">
//                         </a>
//                         <div class="movie-tags my-2">
//                             <span class="badge bg-danger">T16</span>
//                             <span class="badge bg-warning text-dark">Phụ đề</span>
//                             <span class="badge bg-info">2D</span>
//                         </div>
//                         <a href="#">
//                             <h4 id="movie-name">${product[i].tenPhim}</h4>
//                         </a>
//                         <div class="movie-category">Thể loại phim: <span>${product[i].theLoai.tenTheLoai}</span></div>
//                     </div>
//                     <div class="buy-now">
//                         <a href="/product?movie=${product[i].idPhim}">
//                             <img src="/img/ticket.png">&nbsp;&nbsp;MUA VÉ NGAY
//                         </a>
//                     </div>
//                 </div>
//             `;
//         }
//         document.getElementById('product-container').innerHTML = output;
//     }
// });