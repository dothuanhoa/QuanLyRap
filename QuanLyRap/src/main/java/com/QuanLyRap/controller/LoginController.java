package com.QuanLyRap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.QuanLyRap.domain.KhachHang;
import com.QuanLyRap.domain.NhanVien;
import com.QuanLyRap.service.KhachHangService;
import com.QuanLyRap.service.NhanVienService;

@Controller
public class LoginController {
    private final KhachHangService khachHangService;
    private final NhanVienService nhanVienService;

    // Constructor injection
    public LoginController(KhachHangService khachHangService, NhanVienService nhanVienService) {
        this.khachHangService = khachHangService;
        this.nhanVienService = nhanVienService;
    }

    @RequestMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("khachHang", new KhachHang()); // Dùng đối tượng KhachHang để nhận dữ liệu từ form
        return "user/login"; // Trả về trang đăng nhập
    }

    @RequestMapping(value = "/login/verify", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("khachHang") KhachHang khachHang, Model model) {
        // Kiểm tra trong bảng NhanVien trước
        NhanVien existingNhanVien = nhanVienService.findByEmailAndPassword(khachHang.getEmail(),
                khachHang.getMatkhau());
        if (existingNhanVien != null) {
            // Kiểm tra vai trò của nhân viên
            if (existingNhanVien.getRole().getIdRole() == 1) {
                return "redirect:/admin"; // Chuyển hướng đến trang admin
            }
        }

        // Nếu không phải admin, kiểm tra trong bảng KhachHang
        KhachHang existingKhachHang = khachHangService.findByEmailAndPassword(khachHang.getEmail(),
                khachHang.getMatkhau());
        if (existingKhachHang != null) {
            // Kiểm tra vai trò của khách hàng
            if (existingKhachHang.getRole().getIdRole() == 2) {
                return "redirect:/"; // Chuyển hướng đến trang chủ
            }
        }

        // Nếu không tìm thấy tài khoản hoặc thông tin không đúng
        model.addAttribute("error", "Email hoặc mật khẩu không đúng!");
        return "user/login"; // Quay lại trang đăng nhập
    }
}
