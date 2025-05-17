package com.QuanLyRap.repository;

import com.QuanLyRap.domain.QuangCao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuangCaoRepository extends JpaRepository<QuangCao, Integer> {
}