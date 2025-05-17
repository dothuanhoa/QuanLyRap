package com.QuanLyRap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuanLyRap.domain.Ve;

public interface VeRepository extends JpaRepository<Ve, Integer> {
    // Define any custom query methods if needed
    // For example, you can add methods to find tickets by user or showtime
    // List<Ve> findByUserId(Long userId);
    // List<Ve> findBySuatChieuId(Long suatChieuId);

}
