package com.QuanLyRap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QuanLyRap.domain.NhanVien;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
    NhanVien findByEmailAndMatkhau(String email, String matkhau);
}
