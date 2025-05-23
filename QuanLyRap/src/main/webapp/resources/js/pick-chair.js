let seatData = {};
const urlParams = new URLSearchParams(window.location.search);
const idLichChieu = urlParams.get('idLichChieu');

// Lấy thông tin ghế đã đặt
fetch('/api/seats/booked?idLichChieu=' + idLichChieu)
  .then(response => response.json())
  .then(data => {
    seatData = data;
    renderSeats();
  });

function renderSeats() {
  document.getElementById("price").textContent = "0 VNĐ";
  const rows = "ABCDEFGHIJKL".split("");
  const cols = Array.from({ length: 12 }, (_, i) => i + 1);

  const urlParams = new URLSearchParams(window.location.search);
  const showtime = urlParams.get('showtime') || "10h00";
  const showname = urlParams.get('name') || "THÁM TỬ KIÊN: KỲ ÁN KHÔNG ĐẦU";
  document.getElementById("showtime").textContent = showtime;
  document.getElementById("name").textContent = showname;
  const bookedSeats = new Set(seatData[showtime] || []);
  const selectedSeats = new Set();

  const seatMap = document.getElementById("seat-map");
  seatMap.innerHTML = ""; // Xóa ghế cũ nếu có
  const maxSelection = 10;
  let selectedSeatId = null;

  // Tạo bảng ghế
  rows.forEach(row => {
    const rowDiv = document.createElement("div");
    rowDiv.className = "flex gap-2 items-center";

    // Nhãn hàng đầu dòng (ví dụ: A)
    const rowLabelStart = document.createElement("div");
    rowLabelStart.textContent = row;
    rowLabelStart.className = "w-6 text-right font-bold row-left";
    rowDiv.appendChild(rowLabelStart);

    // Ghế từ 12 → 1
    [...cols].reverse().forEach(num => {
      const seatId = row + num;
      const seatBtn = document.createElement("button");
      seatBtn.textContent = num;
      seatBtn.className = "seat rounded-sm border flex items-center justify-center";

      if (bookedSeats.has(seatId)) {
        seatBtn.classList.add("bg-red-600", "text-white", "cursor-not-allowed");
        seatBtn.disabled = true;
      } else {
        seatBtn.classList.add("bg-white", "border");
      }

      seatBtn.dataset.id = seatId;
      seatBtn.addEventListener("click", () => openModal(seatId));
      rowDiv.appendChild(seatBtn);
    });

    // Nhãn hàng cuối dòng (ví dụ: A)
    const rowLabelEnd = document.createElement("div");
    rowLabelEnd.textContent = row;
    rowLabelEnd.className = "w-6 text-left font-bold row-right";
    rowDiv.appendChild(rowLabelEnd);

    seatMap.appendChild(rowDiv);
  });


  function openModal(seatId) {
    selectedSeatId = seatId;
    const isSelected = selectedSeats.has(seatId);
    const modalText = isSelected
      ? `Bạn muốn hủy chọn ghế ${seatId}?`
      : `Bạn muốn chọn ghế ${seatId}?`;
    document.getElementById("modal-text").textContent = modalText;
    document.getElementById("modal").classList.remove("hidden");
  }

  function closeModal() {
    document.getElementById("modal").classList.add("hidden");
    selectedSeatId = null;
  }

  document.getElementById("confirm-btn").addEventListener("click", () => {
    const btn = document.querySelector(`[data-id='${selectedSeatId}']`);
    if (selectedSeats.has(selectedSeatId)) {
      selectedSeats.delete(selectedSeatId);
      btn.classList.remove("bg-black", "text-white");
      btn.classList.add("bg-white", "border");
      price = selectedSeats.size * 50000;
      const formattedPrice = price.toLocaleString("vi-VN");
      console.log(price);
      document.getElementById("price").textContent = formattedPrice + " VNĐ";
    } else {
      if (selectedSeats.size >= maxSelection) {
        alert("Bạn chỉ được chọn tối đa 10 ghế!");
        closeModal();
        return;
      }
      selectedSeats.add(selectedSeatId);
      btn.classList.remove("bg-white", "bg-cyan-400", "border");
      btn.classList.add("bg-black", "text-white");
      price = selectedSeats.size * 50000;
      const formattedPrice = price.toLocaleString("vi-VN");
      console.log(price);
      document.getElementById("price").textContent = formattedPrice + " VNĐ";
    }
    closeModal();
  });

  document.getElementById("cancel-btn").addEventListener("click", closeModal);
}

// Thêm xử lý sự kiện cho nút thanh toán
document.querySelector('.buy').addEventListener('click', processPayment);

// Hàm xử lý thanh toán
async function processPayment() {
  // Kiểm tra nếu chưa chọn ghế
  const selectedSeatElements = document.querySelectorAll('.seat.bg-black');
  if (selectedSeatElements.length === 0) {
    alert('Vui lòng chọn ít nhất một ghế trước khi thanh toán!');
    return;
  }

  // Kiểm tra các trường thông tin
  const fullname = document.getElementById('fullname').value;
  const email = document.getElementById('email').value;
  const phone = document.getElementById('phone').value;
  const termsAccepted = document.querySelector('.terms input[type="checkbox"]').checked;

  if (!fullname || !email || !phone) {
    alert('Vui lòng điền đầy đủ thông tin để tiếp tục!');
    return;
  }

  if (!termsAccepted) {
    alert('Vui lòng đồng ý với điều khoản thanh toán!');
    return;
  }

  // Lấy ID của khách hàng từ input hidden
  const khachHangId = document.getElementById('khachHangId').value;

  // Lấy danh sách ID ghế đã chọn
  const selectedSeatIds = Array.from(selectedSeatElements).map(elem => {
    return elem.getAttribute('data-id');
  });

  // Hiển thị thông báo đang xử lý
  const buyButton = document.querySelector('.buy');
  const originalText = buyButton.textContent;
  buyButton.textContent = 'Đang xử lý...';
  buyButton.disabled = true;

  try {
    // Gọi API thanh toán
    const response = await fetch('/api/seats/payment', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        selectedSeatIds: selectedSeatIds,
        idLichChieu: idLichChieu,
        khachHangId: khachHangId
      })
    });

    const result = await response.json();

    if (result.success) {
      // Hiển thị thông báo thành công
      alert(`Thanh toán thành công! Mã hóa đơn: ${result.invoiceId}\n${result.invoiceDetails}\nVui lòng kiểm tra email của bạn.`);

      // Chuyển hướng về trang chủ sau 2 giây
      setTimeout(() => {
        window.location.href = `/customer/${khachHangId}`;
      }, 2000);
    } else {
      alert('Lỗi thanh toán: ' + result.message);
      buyButton.textContent = originalText;
      buyButton.disabled = false;
    }
  } catch (error) {
    console.error('Error:', error);
    alert('Đã xảy ra lỗi khi thanh toán. Vui lòng thử lại!');
    buyButton.textContent = originalText;
    buyButton.disabled = false;
  }
}
