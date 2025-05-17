package com.QuanLyRap.controller;

import com.QuanLyRap.domain.NhanVien;
import com.QuanLyRap.domain.QuangCao;
import com.QuanLyRap.service.QuangCaoService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/quangcao")
public class QuangCaoController {

    @Autowired
    private QuangCaoService quangCaoService;

    @GetMapping("")
    public String listQuangCao(Model model, HttpSession session) {
        NhanVien admin = (NhanVien) session.getAttribute("loggedInAdmin");
        if (admin != null && admin.getRole().getIdRole() == 1) {
            model.addAttribute("quangcaos", quangCaoService.findAll());
            return "admin/list-quangcao";
        }
        return "error/access-denied";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model, HttpSession session) {

        NhanVien admin = (NhanVien) session.getAttribute("loggedInAdmin");
        if (admin != null && admin.getRole().getIdRole() == 1) {
            model.addAttribute("quangCao", new QuangCao());
            return "admin/create-quangcao";
        }
        return "error/access-denied";

    }

    @PostMapping("/save")
    public String saveQuangCao(@ModelAttribute("quangCao") QuangCao quangCao, HttpSession session) {
        quangCaoService.save(quangCao);
        return "redirect:/admin/quangcao";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuangCao(@PathVariable Integer id, HttpSession session) {
        NhanVien admin = (NhanVien) session.getAttribute("loggedInAdmin");
        if (admin != null && admin.getRole().getIdRole() == 1) {
            quangCaoService.deleteById(id);
            return "redirect:/admin/quangcao";
        }
        return "error/access-denied";

    }
}