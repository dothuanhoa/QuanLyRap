package com.QuanLyRap.repository;

import com.QuanLyRap.domain.Phim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhimRepository extends JpaRepository<Phim, Integer> {
}
