package com.QuanLyRap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QuanLyRap.domain.KhachHang;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {

    KhachHang findByEmailAndMatkhau(String email, String matkhau);

    KhachHang findByEmail(String email);

    KhachHang findBySdt(String sdt);

}