package com.QuanLyRap.controller;

import com.QuanLyRap.domain.KhachHang;
import com.QuanLyRap.domain.Phim;
import com.QuanLyRap.service.KhachHangService;
import com.QuanLyRap.service.PhimService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final KhachHangService khachHangService;
    private final PhimService phimService;

    public CustomerController(KhachHangService khachHangService, PhimService phimService) {
        this.khachHangService = khachHangService;
        this.phimService = phimService;
    }

    // Trang chủ khách hàng
    @GetMapping("/{id}")
    public String getCustomerById(@PathVariable int id, Model model, HttpSession session) {
        KhachHang loggedInUser = (KhachHang) session.getAttribute("loggedInUser");
        if (loggedInUser == null || loggedInUser.getIdkh() != id) {
            return "redirect:/login"; // Chuyển hướng đến trang đăng nhập nếu chưa đăng nhập
        }

        model.addAttribute("khachHang", loggedInUser);
        return "user/cus-index";
    }

    // Trang giới thiệu
    @RequestMapping("/{id}/cus-about-us")
    public String showAboutUs(@PathVariable int id, Model model, HttpSession session) {
        KhachHang loggedInUser = (KhachHang) session.getAttribute("loggedInUser");
        if (loggedInUser == null || loggedInUser.getIdkh() != id) {
            return "redirect:/login";
        }

        model.addAttribute("khachHang", loggedInUser);
        return "user/cus-about-us";
    }

    // Trang chọn ghế
    @RequestMapping("/{id}/cus-pick-chair")
    public String showChair(@PathVariable int id, Model model, HttpSession session) {
        KhachHang loggedInUser = (KhachHang) session.getAttribute("loggedInUser");
        if (loggedInUser == null || loggedInUser.getIdkh() != id) {
            return "redirect:/login";
        }

        model.addAttribute("khachHang", loggedInUser);
        return "user/cus-pick-chair";
    }

    // Trang chi tiết phim
    @GetMapping("/{id}/cus-product")
    public String getMovieByQuery(@PathVariable int id, @RequestParam("movie") int movieId, Model model,
            HttpSession session) {
        KhachHang loggedInUser = (KhachHang) session.getAttribute("loggedInUser");
        if (loggedInUser == null || loggedInUser.getIdkh() != id) {
            return "redirect:/login";
        }

        Phim phim = phimService.getPhimById(movieId);
        if (phim == null) {
            return "error/404"; // Hoặc tạo trang lỗi riêng nếu muốn
        }

        model.addAttribute("khachHang", loggedInUser);
        model.addAttribute("phim", phim);
        return "user/cus-product";
    }

    // Trang danh sách phim
    @RequestMapping("/{id}/cus-movie")
    public String showMovie(@PathVariable int id, Model model, HttpSession session) {
        KhachHang loggedInUser = (KhachHang) session.getAttribute("loggedInUser");
        if (loggedInUser == null || loggedInUser.getIdkh() != id) {
            return "redirect:/login";
        }

        model.addAttribute("khachHang", loggedInUser);
        model.addAttribute("movies", phimService.getAllMovies());
        return "user/cus-movie";
    }

    // Xử lý đăng xuất
    @RequestMapping("/{id}/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Xóa session
        return "redirect:/"; // Chuyển hướng về trang index
    }
}
