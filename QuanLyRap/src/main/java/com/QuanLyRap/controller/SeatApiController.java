package com.QuanLyRap.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.QuanLyRap.domain.Ghe;
import com.QuanLyRap.domain.SuatChieu;
import com.QuanLyRap.service.SuatChieuService;

@RestController
@RequestMapping("/api/seats")
public class SeatApiController {

    @Autowired
    private SuatChieuService suatChieuService;

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
}