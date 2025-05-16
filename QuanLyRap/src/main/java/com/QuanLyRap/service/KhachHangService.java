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

    public KhachHang findById(long id) {
        return this.khachHangRepository.findById(id).orElse(null);
    }

    public KhachHang saveKhachHang(KhachHang khachHang) {
        return this.khachHangRepository.save(khachHang);
    }

    public KhachHang findByEmailAndPassword(String email, String matkhau) {
        return khachHangRepository.findByEmailAndMatkhau(email, matkhau);
    }

    public KhachHang findByEmail(String email) {
        return khachHangRepository.findByEmail(email);
    }

    public KhachHang findBySdt(String sdt) {
        return khachHangRepository.findBySdt(sdt);
    }
}
