package com.QuanLyRap.repository;

import com.QuanLyRap.domain.SuatChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuatChieuRepository extends JpaRepository<SuatChieu, Integer> {
}
