package com.QuanLyRap.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.QuanLyRap.domain.KhachHang;
import com.QuanLyRap.service.KhachHangService;

@Controller
public class LoginController {
    private final KhachHangService khachHangService;

    // Constructor injection
    public LoginController(KhachHangService khachHangService) {
        this.khachHangService = khachHangService;
    }

    @RequestMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("khachHang", new KhachHang()); // Dùng đối tượng KhachHang để nhận dữ liệu từ form
        return "user/login"; // Trả về trang đăng nhập
    }

    @RequestMapping(value = "/login/verify", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("khachHang") KhachHang khachHang, Model model, HttpSession session) {
        // Kiểm tra trong bảng KhachHang
        KhachHang existingKhachHang = khachHangService.findByEmailAndPassword(khachHang.getEmail(),
                khachHang.getMatkhau());
        if (existingKhachHang != null) {
            session.setAttribute("loggedInUser", existingKhachHang); // Lưu thông tin khách hàng vào session
            // Chuyển hướng đến trang khách hàng với id trong URL
            return "redirect:/customer/" + existingKhachHang.getIdkh();
        }

        // Nếu không tìm thấy tài khoản hoặc thông tin không đúng
        model.addAttribute("error", "Email hoặc mật khẩu không đúng!");
        return "user/login"; // Quay lại trang đăng nhập
    }
}
