package com.QuanLyRap.repository;

import java.util.Optional;

import com.QuanLyRap.domain.Ghe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GheRepository extends JpaRepository<Ghe, Integer> {
    Optional<Ghe> findByTenGheAndSuatChieu_IdSuatChieu(String tenGhe, int idSuatChieu);
}
