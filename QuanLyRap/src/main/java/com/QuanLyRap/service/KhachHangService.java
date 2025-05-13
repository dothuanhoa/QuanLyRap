package com.QuanLyRap.service;

import org.springframework.stereotype.Service;

import com.QuanLyRap.domain.KhachHang;
import com.QuanLyRap.repository.KhachHangRepository;

@Service
public class KhachHangService {
    private final KhachHangRepository khachHangRepository;

    public KhachHangService(KhachHangRepository khachHangRepository) {
        this.khachHangRepository = khachHangRepository;
    }

    public KhachHang saveKhachHang(KhachHang khachHang) {
        return this.khachHangRepository.save(khachHang);
    }

    public KhachHang findByEmailAndPassword(String email, String matkhau) {
        return khachHangRepository.findByEmailAndMatkhau(email, matkhau);
    }
}
