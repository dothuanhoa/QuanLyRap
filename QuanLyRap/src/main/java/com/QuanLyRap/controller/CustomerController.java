package com.QuanLyRap.controller;

import com.QuanLyRap.domain.KhachHang;
import com.QuanLyRap.domain.Phim;
import com.QuanLyRap.service.KhachHangService;
import com.QuanLyRap.service.PhimService;
import com.QuanLyRap.util.PasswordUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    // Trang cập nhật thông tin (chỉ cho khách đã login)
    @GetMapping("/edit-profile")
    public String showEditProfile(HttpSession session, Model model) {
        KhachHang loggedInUser = (KhachHang) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        // Lấy lại thông tin mới nhất từ DB
        KhachHang khachHang = khachHangService.findById(loggedInUser.getIdkh());
        model.addAttribute("khachHang", khachHang);
        return "user/edit-profile";
    }

    // Xử lý cập nhật thông tin
    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute("khachHang") KhachHang khachHang,
            HttpSession session, Model model) {
        KhachHang loggedInUser = (KhachHang) session.getAttribute("loggedInUser");
        if (loggedInUser == null ||
                !loggedInUser.getIdkh().equals(khachHang.getIdkh())) {
            return "redirect:/login";
        }
        try {
            // Lấy lại các trường không có trên form để tránh null
            KhachHang old = khachHangService.findById(khachHang.getIdkh());
            khachHang.setEmail(old.getEmail()); // Không cho sửa email
            khachHang.setRole(old.getRole());
            khachHang.setHoaDons(old.getHoaDons());
            khachHang.setVeList(old.getVeList());
            khachHang.setPhanHoiList(old.getPhanHoiList());
            khachHang.setNgaysinh(old.getNgaysinh());
            khachHang.setGioitinh(old.getGioitinh());

            // Mã hóa mật khẩu trước khi lưu
            if (khachHang.getMatkhau() != null && !khachHang.getMatkhau().isEmpty()) {
                khachHang.setMatkhau(PasswordUtil.hashPassword(khachHang.getMatkhau()));
            } else {
                // Nếu không nhập mật khẩu mới, giữ nguyên mật khẩu cũ
                khachHang.setMatkhau(old.getMatkhau());
            }

            khachHangService.saveKhachHang(khachHang);
            KhachHang updated = khachHangService.findById(khachHang.getIdkh());
            session.setAttribute("loggedInUser", updated);
            model.addAttribute("success", "Cập nhật thành công!");
            model.addAttribute("khachHang", updated);
        } catch (Exception e) {
            e.printStackTrace(); // Xem lỗi chi tiết trên console
            model.addAttribute("error", "Có lỗi xảy ra, vui lòng thử lại!");
            model.addAttribute("khachHang", khachHang);
        }
        return "user/edit-profile";
    }
}
