let currentLimit = 3;

function renderRows() {
  const rows = document.querySelectorAll('#phimList tr');
  rows.forEach((row, index) => {
    if (currentLimit === 'all' || index < currentLimit) {
      row.style.display = '';
    } else {
      row.style.display = 'none';
    }
  });
}
function handleClick(event) {
    event.preventDefault(); 
}
function setRowLimit(limit) {
  currentLimit = limit;
  renderRows();
}

function themPhim() {
  const tbody = document.getElementById('phimList');
  const newRow = document.createElement('tr');
  newRow.innerHTML = `
    <td><input type="checkbox" class="row-check"/></td>
    <td>newID</td>
    <td>newTênPhim</td>
  `;
  tbody.appendChild(newRow);
  renderRows();
}

function searchPhim() {
  const keyword = document.getElementById('search').value.toLowerCase();
  const rows = document.querySelectorAll('#phimList tr');
  rows.forEach(row => {
    const text = row.textContent.toLowerCase();
    row.style.display = text.includes(keyword) ? '' : 'none';
  });
}

function xoaPhim() {
  const checked = document.querySelectorAll('.row-check:checked');
  checked.forEach(cb => cb.closest('tr').remove());
  renderRows();
}

function toggleAll(source) {
  const checkboxes = document.querySelectorAll('.row-check');
  checkboxes.forEach(cb => cb.checked = source.checked);
}

// Gọi khi trang vừa tải
window.onload = () => renderRows();
