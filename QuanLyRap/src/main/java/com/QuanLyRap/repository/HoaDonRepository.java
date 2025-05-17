package com.QuanLyRap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuanLyRap.domain.HoaDon;

public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    // Define any custom query methods if needed
    // For example, you can add methods to find tickets by user or showtime
    // List<HoaDon> findByUserId(Long userId);
    // List<HoaDon> findBySuatChieuId(Long suatChieuId);

}
