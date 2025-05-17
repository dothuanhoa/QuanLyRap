package com.QuanLyRap.service;

import com.QuanLyRap.domain.Ghe;
import com.QuanLyRap.domain.HoaDon;
import com.QuanLyRap.domain.KhachHang;
import com.QuanLyRap.domain.LichChieu;
import com.QuanLyRap.domain.SuatChieu;
import com.QuanLyRap.domain.Ve;
import com.QuanLyRap.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class HoaDonService {

        @Autowired
        private HoaDonRepository hoaDonRepository;

        @Autowired
        private GheRepository gheRepository;

        @Autowired
        private LichChieuRepository lichChieuRepository;

        @Autowired
        private KhachHangRepository khachHangRepository;

        @Autowired
        private VeRepository veRepository;

        public HoaDon createHoaDon(List<String> selectedSeats, int idLichChieu, Long khachHangId) {
                // Lấy thông tin lịch chiếu
                LichChieu lichChieu = lichChieuRepository.findById(idLichChieu)
                                .orElseThrow(() -> new RuntimeException("Không tìm thấy lịch chiếu"));

                // Lấy thông tin khách hàng
                KhachHang khachHang = khachHangRepository.findById(khachHangId)
                                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng"));

                // Tạo hóa đơn mới
                HoaDon hoaDon = new HoaDon();
                hoaDon.setNgaylaphd(LocalDate.now());
                hoaDon.setKhachHang(khachHang);

                // Lưu hóa đơn TRƯỚC để có ID
                hoaDon = hoaDonRepository.save(hoaDon);

                // Lấy suất chiếu từ lịch chiếu
                SuatChieu suatChieu = lichChieu.getSuatChieuList().iterator().next();
                StringBuilder selectedSeatsInfo = new StringBuilder();
                int totalPrice = 0;

                for (String seatId : selectedSeats) {
                        Ghe ghe = gheRepository.findByTenGheAndSuatChieu_IdSuatChieu(seatId, suatChieu.getIdSuatChieu())
                                        .orElseThrow(() -> new RuntimeException("Không tìm thấy ghế: " + seatId));

                        // Cập nhật trạng thái ghế
                        ghe.setTrangThai(true);
                        gheRepository.save(ghe);

                        // Tạo vé với reference tới hóa đơn đã được lưu
                        Ve ve = new Ve();
                        ve.setHoaDon(hoaDon); // Bây giờ hoaDon đã có ID
                        ve.setGhe(ghe);
                        ve.setKhachHang(khachHang);
                        ve.setPhim(lichChieu.getPhim());
                        ve.setLichChieu(lichChieu);
                        ve.setThoiGianMua(LocalDateTime.now());
                        ve.setGiaVe(ghe.getLoaiGhe().getGia());
                        veRepository.save(ve);

                        selectedSeatsInfo.append(ghe.getTenGhe()).append(", ");
                        totalPrice += ghe.getLoaiGhe().getGia();
                }

                // Xóa dấu phẩy và khoảng trắng cuối cùng
                if (selectedSeatsInfo.length() > 0) {
                        selectedSeatsInfo.setLength(selectedSeatsInfo.length() - 2);
                }

                // Tạo ghi chú với thông tin đầy đủ
                String ghiChu = String.format("Phòng: %s, Phim: %s, Suất: %s, Ngày: %s, Ghế: %s",
                                lichChieu.getPhim().getPhongChieu().getTenPhongChieu(),
                                lichChieu.getPhim().getTenPhim(),
                                suatChieu.getThoiGianBatDau(),
                                lichChieu.getNgayChieu(),
                                selectedSeatsInfo.toString());

                // Cập nhật hóa đơn với thông tin cuối
                hoaDon.setGhiChu(ghiChu);
                hoaDon.setTongtien(totalPrice);
                return hoaDonRepository.save(hoaDon);
        }

        public List<HoaDon> findByKhachHang(KhachHang khachHang) {
                return hoaDonRepository.findByKhachHangOrderByNgaylaphdDesc(khachHang);
        }
}
