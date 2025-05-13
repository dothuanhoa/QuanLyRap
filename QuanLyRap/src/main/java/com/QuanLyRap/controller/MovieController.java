package com.QuanLyRap.controller;

import com.QuanLyRap.domain.Phim;
import com.QuanLyRap.service.PhimService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final PhimService phimService;

    public MovieController(PhimService phimService) {
        this.phimService = phimService;
    }

    @GetMapping("/api/movies")
    public List<Phim> getAllMovies() {
        return phimService.getAllMovies();
    }
}
