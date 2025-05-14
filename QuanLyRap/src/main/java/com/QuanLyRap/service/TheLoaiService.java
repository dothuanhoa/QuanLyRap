package com.QuanLyRap.service;

import com.QuanLyRap.domain.TheLoai;
import com.QuanLyRap.repository.TheLoaiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheLoaiService {
    private final TheLoaiRepository theLoaiRepository;

    public TheLoaiService(TheLoaiRepository theLoaiRepository) {
        this.theLoaiRepository = theLoaiRepository;
    }

    public List<TheLoai> findAll() {
        return theLoaiRepository.findAll();
    }

    public TheLoai findById(int id) {
        return theLoaiRepository.findById(id).orElse(null);
    }

    public TheLoai findByTenTheLoai(String tenTheLoai) {
        return theLoaiRepository.findByTenTheLoai(tenTheLoai);
    }

    public void save(TheLoai theLoai) {
        theLoaiRepository.save(theLoai);
    }
}
