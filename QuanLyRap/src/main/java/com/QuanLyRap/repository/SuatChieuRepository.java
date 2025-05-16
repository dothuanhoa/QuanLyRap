package com.QuanLyRap.repository;

import com.QuanLyRap.domain.SuatChieu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuatChieuRepository extends JpaRepository<SuatChieu, Integer> {
    List<SuatChieu> findByLichChieu_IdLichChieu(int idLichChieu);
}
