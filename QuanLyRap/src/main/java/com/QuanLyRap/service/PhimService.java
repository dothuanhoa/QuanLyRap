package com.QuanLyRap.service;

import com.QuanLyRap.domain.Phim;
import com.QuanLyRap.repository.PhimRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhimService {

    private final PhimRepository phimRepository;

    public PhimService(PhimRepository phimRepository) {
        this.phimRepository = phimRepository;
    }

    public List<Phim> getAllMovies() {
        return phimRepository.findAll();
    }
}
