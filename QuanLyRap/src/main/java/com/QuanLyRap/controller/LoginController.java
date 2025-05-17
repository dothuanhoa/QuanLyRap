package com.QuanLyRap.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.QuanLyRap.domain.KhachHang;
import com.QuanLyRap.domain.NhanVien;
import com.QuanLyRap.service.KhachHangService;
import com.QuanLyRap.service.NhanVienService;
import com.QuanLyRap.util.PasswordUtil;

@Controller
public class LoginController {
    private final KhachHangService khachHangService;
    private final NhanVienService nhanVienService; // Thêm NhanVienService

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
    public String handleLogin(@ModelAttribute("khachHang") KhachHang khachHang, Model model, HttpSession session) {
        String hashedPassword = PasswordUtil.hashPassword(khachHang.getMatkhau());

        // Kiểm tra trong bảng nhân viên trước (admin)
        NhanVien admin = nhanVienService.findByEmailAndPasswordAndRole(
                khachHang.getEmail(),
                hashedPassword,
                1 // idRole = 1 cho admin
        );

        if (admin != null) {
            session.setAttribute("loggedInAdmin", admin);
            return "redirect:/admin"; // Chuyển đến trang admin
        }

        // Nếu không phải admin, kiểm tra trong bảng khách hàng
        KhachHang existingKhachHang = khachHangService.findByEmailAndPassword(
                khachHang.getEmail(),
                hashedPassword);

        if (existingKhachHang != null) {
            session.setAttribute("loggedInUser", existingKhachHang);
            return "redirect:/customer/" + existingKhachHang.getIdkh();
        }

        model.addAttribute("error", "Email hoặc mật khẩu không đúng!");
        return "user/login";
    }
}
