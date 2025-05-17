package com.QuanLyRap.service;

import com.QuanLyRap.domain.Ghe;
import com.QuanLyRap.domain.HoaDon;
import com.QuanLyRap.domain.KhachHang;
import com.QuanLyRap.domain.LichChieu;
import com.QuanLyRap.domain.Ve;
import com.QuanLyRap.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

                // Tạo ghi chú
                String ghiChu = String.format("Phòng: %s, Phim: %s, Suất: %s, Ngày: %s",
                                lichChieu.getPhim().getPhongChieu().getTenPhongChieu(),
                                lichChieu.getPhim().getTenPhim(),
                                lichChieu.getSuatChieuList().iterator().next().getThoiGianBatDau(),
                                lichChieu.getNgayChieu());
                hoaDon.setGhiChu(ghiChu);

                hoaDonRepository.save(hoaDon);

                // Lấy thông tin suất chiếu từ lịch chiếu
                int idSuatChieu = lichChieu.getSuatChieuList().iterator().next().getIdSuatChieu();

                // Tạo vé và cập nhật trạng thái ghế
                for (String seatId : selectedSeats) {
                        // Tìm ghế theo tên ghế (A1, B2, ...) và suất chiếu
                        Ghe ghe = gheRepository.findByTenGheAndSuatChieu_IdSuatChieu(seatId, idSuatChieu)
                                        .orElseThrow(() -> new RuntimeException("Không tìm thấy ghế: " + seatId));

                        // Tạo vé
                        Ve ve = new Ve();
                        ve.setHoaDon(hoaDon);
                        ve.setGhe(ghe);
                        ve.setKhachHang(khachHang);
                        ve.setPhim(lichChieu.getPhim());
                        veRepository.save(ve);

                        // Cập nhật trạng thái ghế
                        ghe.setTrangThai(true);
                        gheRepository.save(ghe);
                }

                return hoaDon;
        }
}
