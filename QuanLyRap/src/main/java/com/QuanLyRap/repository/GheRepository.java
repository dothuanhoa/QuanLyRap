package com.QuanLyRap.repository;

import com.QuanLyRap.domain.Ghe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GheRepository extends JpaRepository<Ghe, Integer> {
}
