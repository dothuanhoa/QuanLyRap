package com.QuanLyRap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QuanLyRap.domain.HoaDon;
import com.QuanLyRap.domain.KhachHang;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    // Define any custom query methods if needed
    // For example, you can add methods to find tickets by user or showtime
    // List<HoaDon> findByUserId(Long userId);
    // List<HoaDon> findBySuatChieuId(Long suatChieuId);
    List<HoaDon> findByKhachHangOrderByNgaylaphdDesc(KhachHang khachHang);

}
