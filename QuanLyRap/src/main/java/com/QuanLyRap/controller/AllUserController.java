package com.QuanLyRap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.QuanLyRap.domain.KhachHang;
import com.QuanLyRap.domain.Phim;
import com.QuanLyRap.service.KhachHangService;
import com.QuanLyRap.service.PhimService;

@Controller
public class AllUserController {

    private final KhachHangService khachHangService;
    private final PhimService phimService;

    public AllUserController(KhachHangService khachHangService, PhimService phimService) {
        this.khachHangService = khachHangService;
        this.phimService = phimService;
    }

    @RequestMapping("/")
    public String getHomePage() {
        return "user/index";
    }

    @RequestMapping("/about-us")
    public String showAboutUs() {
        return "user/about-us";
    }

    @RequestMapping("/movie")
    public String showMovie(Model model) {
        model.addAttribute("movies", phimService.getAllMovies());
        return "user/movie";
    }

    @RequestMapping("/pick-chair")
    public String showChair() {
        return "user/pick-chair";
    }

    @GetMapping("/product")
    public String getMovieByQuery(@RequestParam("movie") int movieId, Model model) {
        Phim phim = phimService.getPhimById(movieId);
        if (phim == null) {
            return "error/404"; // Hoặc tạo trang lỗi riêng nếu muốn
        }
        model.addAttribute("phim", phim);
        return "user/product";
    }

    @RequestMapping("/registered")
    public String showRegister(Model model) {
        model.addAttribute("newKhachHang", new KhachHang());
        return "user/registered";
    }

    @RequestMapping(value = "/registered/save", method = RequestMethod.POST)
    public String getRegister(Model model, @ModelAttribute("newKhachHang") KhachHang khachHang) {
        this.khachHangService.saveKhachHang(khachHang);
        return "redirect:/login";
    }

    // Trang khách hàng
    @RequestMapping("/customer")
    public String showCustomerPage(@RequestParam("id") int id, Model model) {
        // Truy vấn thông tin khách hàng từ database
        KhachHang khachHang = khachHangService.findById(id);
        if (khachHang == null) {
            return "redirect:/login"; // Chuyển hướng đến trang đăng nhập nếu không tìm thấy khách hàng
        }

        model.addAttribute("khachHang", khachHang);
        return "user/cus-index"; // Trả về trang khách hàng
    }
}
