package com.QuanLyRap.repository;

import com.QuanLyRap.domain.LichChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichChieuRepository extends JpaRepository<LichChieu, Integer> {
}
