package com.QuanLyRap.controller;

import com.QuanLyRap.domain.NhanVien;
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
        NhanVien admin = (NhanVien) session.getAttribute("loggedInAdmin");
        if (admin != null && admin.getRole().getIdRole() == 1) {
            model.addAttribute("phims", phimService.getAllMovies());
            return "admin/list-phim";
        }
        return "error/access-denied";

    }

    @GetMapping("/create")
    public String showForm(Model model, HttpSession session) {
        NhanVien admin = (NhanVien) session.getAttribute("loggedInAdmin");
        if (admin != null && admin.getRole().getIdRole() == 1) {
            model.addAttribute("phim", new Phim());
            model.addAttribute("theLoaiList", theLoaiService.findAll()); // Truyền danh sách thể loại vào form
            return "admin/create-phim";
        }
        return "error/access-denied";

    }

    // Phương thức thêm mới phim
    @PostMapping("/save")
    public String savePhim(@ModelAttribute("phim") Phim phim, @RequestParam("tenTheLoai") String tenTheLoai,
            HttpSession session) {
        NhanVien admin = (NhanVien) session.getAttribute("loggedInAdmin");
        if (admin != null && admin.getRole().getIdRole() == 1) {
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
        return "error/access-denied";
    }

    // Phương thức cập nhật phim
    @PostMapping("/update")
    public String updatePhim(@ModelAttribute("phim") Phim phim, BindingResult result,
            @RequestParam("tenTheLoai") String tenTheLoai, HttpSession session) {
        NhanVien admin = (NhanVien) session.getAttribute("loggedInAdmin");
        if (admin != null && admin.getRole().getIdRole() == 1) {
            if (result.hasErrors()) {
                return "admin/edit"; // Trả về form nếu có lỗi
            }

            try {
                // Get the existing movie first to ensure it exists
                Phim existingPhim = phimService.getPhimById(phim.getIdPhim());
                if (existingPhim == null) {
                    return "error/404";
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
            } catch (Exception e) {
                // Log the exception
                System.err.println("Error updating movie: " + e.getMessage());
                e.printStackTrace();

                // Add error message to the model
                result.rejectValue("tenPhim", "error.phim", "Có lỗi xảy ra khi cập nhật phim.");
                return "admin/edit";
            }
        }
        return "error/access-denied";
    }

    @GetMapping("/edit/{id}")
    public String editPhim(@PathVariable("id") int id, Model model, HttpSession session) {
        NhanVien admin = (NhanVien) session.getAttribute("loggedInAdmin");
        if (admin != null && admin.getRole().getIdRole() == 1) {
            Phim phim = phimService.getPhimById(id);
            if (phim == null) {
                return "error/404"; // Nếu không tìm thấy phim, chuyển đến trang lỗi
            }
            model.addAttribute("phim", phim);
            return "admin/edit"; // Trả về trang chỉnh sửa
        }
        return "error/access-denied";
    }

    @GetMapping("/delete/{id}")
    public String deletePhim(@PathVariable int id, HttpSession session, Model model) {
        NhanVien admin = (NhanVien) session.getAttribute("loggedInAdmin");
        if (admin != null && admin.getRole().getIdRole() == 1) {
            try {
                // Check if the movie exists first
                Phim phim = phimService.getPhimById(id);
                if (phim == null) {
                    return "error/404"; // Movie not found
                }
                phimService.deletePhim(id);
                return "redirect:/admin/phim";
            } catch (Exception e) {
                // Log the error
                System.err.println("Error deleting movie: " + e.getMessage());
                e.printStackTrace();

                // Add an error message
                model.addAttribute("errorMessage", "Không thể xóa phim này. Có thể có dữ liệu liên quan.");
                model.addAttribute("phims", phimService.getAllMovies());
                return "admin/list-phim";
            }
        }
        return "error/access-denied";
    }
}
