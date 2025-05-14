package com.QuanLyRap.controller;

import com.QuanLyRap.domain.Phim;
import com.QuanLyRap.domain.TheLoai;
import com.QuanLyRap.service.PhimService;
import com.QuanLyRap.service.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/phim")
public class PhimController {

    @Autowired
    private PhimService phimService;

    @Autowired
    private TheLoaiService theLoaiService;

    @GetMapping
    public String listPhim(Model model) {
        model.addAttribute("phims", phimService.getAllMovies());
        return "admin/list-phim";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("phim", new Phim());
        model.addAttribute("theLoaiList", theLoaiService.findAll()); // Truyền danh sách thể loại vào form
        return "admin/create-phim";
    }

    @PostMapping("/save")
    public String savePhim(@ModelAttribute("phim") Phim phim, @RequestParam("tenTheLoai") String tenTheLoai) {
        // Tìm TheLoai theo tên
        TheLoai theLoai = theLoaiService.findByTenTheLoai(tenTheLoai);
        if (theLoai == null) {
            // Nếu không tìm thấy thể loại, tạo mới
            theLoai = new TheLoai();
            theLoai.setTenTheLoai(tenTheLoai);
            theLoaiService.save(theLoai);
        }
        phim.setTheLoai(theLoai);

        // Lưu phim
        phimService.createPhimWithDefaults(phim);
        return "redirect:/admin/phim";
    }

    @GetMapping("/edit/{id}")
    public String editPhim(@PathVariable int id, Model model) {
        Phim phim = phimService.getPhimById(id);
        model.addAttribute("phim", phim);
        model.addAttribute("theLoaiList", theLoaiService.findAll()); // Truyền danh sách thể loại vào form
        return "admin/create";
    }

    @GetMapping("/delete/{id}")
    public String deletePhim(@PathVariable int id) {
        phimService.deletePhim(id);
        return "redirect:/admin/phim";
    }
}
