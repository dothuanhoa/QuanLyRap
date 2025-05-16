package com.QuanLyRap.repository;

import com.QuanLyRap.domain.Phim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PhimRepository extends JpaRepository<Phim, Integer> {
    // Lấy tất cả phim cùng với lịch chiếu và suất chiếu (fetch join)
    @Query("SELECT DISTINCT p FROM Phim p " +
            "LEFT JOIN FETCH p.lichChieuList lc " +
            "LEFT JOIN FETCH lc.suatChieuList")
    List<Phim> findAllWithLichChieuAndSuatChieu();
}
