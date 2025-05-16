package com.QuanLyRap.service;

import com.QuanLyRap.domain.SuatChieu;
import com.QuanLyRap.repository.SuatChieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuatChieuService {

    @Autowired
    private SuatChieuRepository suatChieuRepository;

    public List<SuatChieu> findAll() {
        return suatChieuRepository.findAll();
    }

    public List<SuatChieu> findByLichChieuId(int idLichChieu) {
        return suatChieuRepository.findByLichChieu_IdLichChieu(idLichChieu);
    }
    // Có thể thêm các phương thức khác nếu cần
}
