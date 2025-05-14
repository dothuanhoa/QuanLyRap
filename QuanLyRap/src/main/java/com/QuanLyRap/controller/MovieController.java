package com.QuanLyRap.controller;

import com.QuanLyRap.domain.Phim;
import com.QuanLyRap.service.PhimService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    private final PhimService phimService;

    public MovieController(PhimService phimService) {
        this.phimService = phimService;
    }

    @GetMapping("/movies")
    public List<Phim> getAllMovies() {
        return phimService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public String getMovieDetails(@PathVariable int id, Model model) {
        Phim phim = phimService.getPhimById(id);
        model.addAttribute("phim", phim);
        return "user/product";
    }

    // @PostMapping("/phim")
    // public String createPhim(@RequestBody Phim phim) {
    // phimService.createPhimWithDefaults(phim);
    // return "Phim và các lịch chiếu, suất chiếu, ghế đã được tạo thành công!";
    // }
}
