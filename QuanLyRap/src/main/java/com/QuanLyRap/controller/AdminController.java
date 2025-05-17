package com.QuanLyRap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.QuanLyRap.domain.KhachHang;
import com.QuanLyRap.domain.NhanVien;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String showAdminPage(HttpSession session) {
        KhachHang user = (KhachHang) session.getAttribute("loggedInUser");
        NhanVien admin = (NhanVien) session.getAttribute("loggedInAdmin");
        if (admin != null && admin.getRole().getIdRole() == 1) {
            return "admin/adminpage";
        }
        if (user == null || user.getRole().getIdRole() != 1) {
            return "error/access-denied";
        }
        return "admin/adminpage";
    }

    @GetMapping("/movie-interface")
    public String showMovieInterface(HttpSession session) {
        KhachHang user = (KhachHang) session.getAttribute("loggedInUser");
        NhanVien admin = (NhanVien) session.getAttribute("loggedInAdmin");
        if (admin != null && admin.getRole().getIdRole() == 1) {
            return "admin/movie-interface";
        }
        if (user == null || user.getRole().getIdRole() != 1) {
            return "error/access-denied";
        }
        return "admin/movie-interface";
    }
}
