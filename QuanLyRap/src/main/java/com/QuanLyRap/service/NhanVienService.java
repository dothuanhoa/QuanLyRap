package com.QuanLyRap.service;

import org.springframework.stereotype.Service;

import com.QuanLyRap.domain.NhanVien;
import com.QuanLyRap.repository.NhanVienRepository;

@Service
public class NhanVienService {
    private final NhanVienRepository nhanVienRepository;

    public NhanVienService(NhanVienRepository nhanVienRepository) {
        this.nhanVienRepository = nhanVienRepository;
    }

    public NhanVien findByEmailAndPassword(String email, String matkhau) {
        return nhanVienRepository.findByEmailAndMatkhau(email, matkhau);
    }

    public NhanVien findByEmailAndPasswordAndRole(String email, String hashedPassword, int idRole) {
        return nhanVienRepository.findByEmailAndMatkhauAndRole_IdRole(email, hashedPassword, idRole);
    }
}
