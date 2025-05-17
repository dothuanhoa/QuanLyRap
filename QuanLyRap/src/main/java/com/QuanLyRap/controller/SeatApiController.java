package com.QuanLyRap.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.QuanLyRap.domain.Ghe;
import com.QuanLyRap.domain.HoaDon;
import com.QuanLyRap.domain.SuatChieu;
import com.QuanLyRap.service.HoaDonService;
import com.QuanLyRap.service.SuatChieuService;

@RestController
@RequestMapping("/api/seats")
public class SeatApiController {

    @Autowired
    private SuatChieuService suatChieuService;
    @Autowired
    private HoaDonService hoaDonService;

    // Trả về danh sách ghế đã đặt cho từng suất chiếu
    @GetMapping("/booked")
    public Map<String, List<String>> getBookedSeats(@RequestParam("idLichChieu") int idLichChieu) {
        Map<String, List<String>> seatData = new HashMap<>();
        List<SuatChieu> suatChieus = suatChieuService.findByLichChieuId(idLichChieu);
        for (SuatChieu suatChieu : suatChieus) {
            String time = suatChieu.getThoiGianBatDau();
            List<String> booked = new ArrayList<>();
            for (Ghe ghe : suatChieu.getGheList()) {
                if (ghe.isTrangThai()) {
                    booked.add(ghe.getTenGhe());
                }
            }
            seatData.put(time, booked);
        }
        return seatData;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> processPayment(@RequestBody Map<String, Object> paymentData) {
        try {
            // Lấy dữ liệu từ request body
            @SuppressWarnings("unchecked")
            List<String> selectedSeatIds = (List<String>) paymentData.get("selectedSeatIds");
            int idLichChieu = Integer.parseInt(paymentData.get("idLichChieu").toString());
            Long khachHangId = Long.parseLong(paymentData.get("khachHangId").toString());

            // Tạo hóa đơn với danh sách ghế đã chọn
            HoaDon hoaDon = hoaDonService.createHoaDon(selectedSeatIds, idLichChieu, khachHangId);

            // Trả về thông tin hóa đơn đã tạo
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Thanh toán thành công");
            response.put("invoiceId", hoaDon.getIdhoadon());
            response.put("invoiceDetails", hoaDon.getGhiChu());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Lỗi khi thanh toán: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}