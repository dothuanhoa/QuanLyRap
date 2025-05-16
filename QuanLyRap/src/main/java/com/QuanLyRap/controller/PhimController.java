package com.QuanLyRap.controller;

import com.QuanLyRap.domain.KhachHang;
import com.QuanLyRap.domain.Phim;
import com.QuanLyRap.domain.TheLoai;
import com.QuanLyRap.service.PhimService;
import com.QuanLyRap.service.TheLoaiService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/phim")
public class PhimController {

    @Autowired
    private PhimService phimService;

    @Autowired
    private TheLoaiService theLoaiService;

    @GetMapping
    public String listPhim(Model model, HttpSession session) {
        KhachHang user = (KhachHang) session.getAttribute("loggedInUser");
        if (user == null || user.getRole().getIdRole() != 1) {
            return "error/access-denied";
        }
        model.addAttribute("phims", phimService.getAllMovies());
        return "admin/list-phim";
    }

    @GetMapping("/create")
    public String showForm(Model model, HttpSession session) {
        KhachHang user = (KhachHang) session.getAttribute("loggedInUser");
        if (user == null || user.getRole().getIdRole() != 1) {
            return "error/access-denied";
        }
        model.addAttribute("phim", new Phim());
        model.addAttribute("theLoaiList", theLoaiService.findAll()); // Truyền danh sách thể loại vào form
        return "admin/create-phim";
    }

    // Phương thức thêm mới phim
    @PostMapping("/save")
    public String savePhim(@ModelAttribute("phim") Phim phim, @RequestParam("tenTheLoai") String tenTheLoai,
            HttpSession session) {
        KhachHang user = (KhachHang) session.getAttribute("loggedInUser");
        if (user == null || user.getRole().getIdRole() != 1) {
            return "error/access-denied";
        }
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

    // Phương thức cập nhật phim
    @PostMapping("/update")
    public String updatePhim(@ModelAttribute("phim") Phim phim, BindingResult result,
            @RequestParam("tenTheLoai") String tenTheLoai, HttpSession session) {
        KhachHang user = (KhachHang) session.getAttribute("loggedInUser");
        if (user == null || user.getRole().getIdRole() != 1) {
            return "error/access-denied";
        }
        if (result.hasErrors()) {
            return "admin/edit"; // Trả về form nếu có lỗi
        }

        // Xử lý thể loại
        TheLoai theLoai = theLoaiService.findByTenTheLoai(tenTheLoai);
        if (theLoai == null) {
            theLoai = new TheLoai();
            theLoai.setTenTheLoai(tenTheLoai);
            theLoaiService.save(theLoai);
        }
        phim.setTheLoai(theLoai);

        // Cập nhật phim
        phimService.updatePhim(phim);

        return "redirect:/admin/phim";
    }

    @GetMapping("/edit/{id}")
    public String editPhim(@PathVariable("id") int id, Model model, HttpSession session) {
        KhachHang user = (KhachHang) session.getAttribute("loggedInUser");
        if (user == null || user.getRole().getIdRole() != 1) {
            return "error/access-denied";
        }
        Phim phim = phimService.getPhimById(id);
        if (phim == null) {
            return "error/404"; // Nếu không tìm thấy phim, chuyển đến trang lỗi
        }
        model.addAttribute("phim", phim);
        return "admin/edit"; // Trả về trang chỉnh sửa
    }

    @GetMapping("/delete/{id}")
    public String deletePhim(@PathVariable int id, HttpSession session) {
        KhachHang user = (KhachHang) session.getAttribute("loggedInUser");
        if (user == null || user.getRole().getIdRole() != 1) {
            return "error/access-denied";
        }
        phimService.deletePhim(id);
        return "redirect:/admin/phim";
    }
}
