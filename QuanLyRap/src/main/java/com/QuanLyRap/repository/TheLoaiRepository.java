package com.QuanLyRap.repository;

import com.QuanLyRap.domain.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheLoaiRepository extends JpaRepository<TheLoai, Integer> {
    TheLoai findByTenTheLoai(String tenTheLoai);

}
