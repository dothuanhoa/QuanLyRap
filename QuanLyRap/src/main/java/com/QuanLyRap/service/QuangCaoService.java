package com.QuanLyRap.service;

import com.QuanLyRap.domain.QuangCao;
import java.util.List;

public interface QuangCaoService {
    List<QuangCao> findAll();
    QuangCao findById(Integer id);
    QuangCao save(QuangCao quangCao);
    void deleteById(Integer id);
}