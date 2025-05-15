package com.QuanLyRap.service;

import com.QuanLyRap.domain.*;
import com.QuanLyRap.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhimService {

    private final PhimRepository phimRepository;
    private final LichChieuRepository lichChieuRepository;
    private final SuatChieuRepository suatChieuRepository;
    private final GheRepository gheRepository;

    public PhimService(PhimRepository phimRepository,
            LichChieuRepository lichChieuRepository,
            SuatChieuRepository suatChieuRepository,
            GheRepository gheRepository) {
        this.phimRepository = phimRepository;
        this.lichChieuRepository = lichChieuRepository;
        this.suatChieuRepository = suatChieuRepository;
        this.gheRepository = gheRepository;
    }

    public List<Phim> getAllMovies() {
        return phimRepository.findAll();
    }

    public Phim getPhimById(int id) {
        return phimRepository.findById(id).orElse(null);
    }

    public void deletePhim(int id) {
        phimRepository.deleteById(id);
    }

    public void createPhimWithDefaults(Phim phim) {
        // Lưu phim
        phimRepository.save(phim);

        // Tạo 3 lịch chiếu (ngày hiện tại và 2 ngày tiếp theo)
        for (int i = 0; i < 3; i++) {
            LichChieu lichChieu = new LichChieu();
            lichChieu.setNgayChieu(LocalDate.now().plusDays(i));
            lichChieu.setPhim(phim);
            lichChieuRepository.save(lichChieu);

            // Tạo 5 suất chiếu cho mỗi lịch chiếu
            String[] thoiGianBatDau = { "11:10", "14:10", "17:20", "20:30", "23:30" };
            for (String time : thoiGianBatDau) {
                SuatChieu suatChieu = new SuatChieu();
                suatChieu.setThoiGianBatDau(time);
                suatChieu.setLichChieu(lichChieu);
                suatChieuRepository.save(suatChieu);

                // Tạo 144 ghế cho mỗi suất chiếu
                List<Ghe> gheList = new ArrayList<>();
                for (char row = 'A'; row <= 'L'; row++) {
                    for (int col = 1; col <= 12; col++) {
                        Ghe ghe = new Ghe();
                        ghe.setTenGhe(row + String.valueOf(col));
                        ghe.setSuatChieu(suatChieu);
                        gheList.add(ghe);
                    }
                }
                gheRepository.saveAll(gheList);
            }
        }
    }

    public void updatePhim(Phim phim) {
        if (phimRepository.existsById(phim.getIdPhim())) {
            phimRepository.save(phim); // Cập nhật phim
        } else {
            throw new IllegalArgumentException("Phim không tồn tại để cập nhật.");
        }
    }
}
