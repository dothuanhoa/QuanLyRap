package com.QuanLyRap.service;

import com.QuanLyRap.domain.QuangCao;
import com.QuanLyRap.repository.QuangCaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuangCaoServiceImpl implements QuangCaoService {
    @Autowired
    private QuangCaoRepository quangCaoRepository;

    @Override
    public List<QuangCao> findAll() {
        return quangCaoRepository.findAll();
    }

    @Override
    public QuangCao findById(Integer id) {
        return quangCaoRepository.findById(id).orElse(null);
    }

    @Override
    public QuangCao save(QuangCao quangCao) {
        return quangCaoRepository.save(quangCao);
    }

    @Override
    public void deleteById(Integer id) {
        quangCaoRepository.deleteById(id);
    }
}