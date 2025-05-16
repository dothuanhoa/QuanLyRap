package com.QuanLyRap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.QuanLyRap.domain.KhachHang;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String showAdminPage(HttpSession session) {
        KhachHang user = (KhachHang) session.getAttribute("loggedInUser");
        if (user == null || user.getRole().getIdRole() != 1) {
            return "error/access-denied";
        }
        return "admin/adminpage";
    }

    @GetMapping("/movie-interface")
    public String showMovieInterface(HttpSession session) {
        KhachHang user = (KhachHang) session.getAttribute("loggedInUser");
        if (user == null || user.getRole().getIdRole() != 1) {
            return "error/access-denied";
        }
        return "admin/movie-interface";
    }
}
