package com.QuanLyRap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.QuanLyRap.domain.KhachHang;
import com.QuanLyRap.service.KhachHangService;

@Controller
public class AllUserController {
    private final KhachHangService khachHangService;

    public AllUserController(KhachHangService khachHangService) {
        this.khachHangService = khachHangService;
    }

    @RequestMapping("/")
    public String getHomePage() {
        return "user/index";
    }

    @RequestMapping("/about-us")
    public String showAboutUs() {
        return "user/about-us";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "user/login";
    }

    @RequestMapping("/movie")
    public String showMovie() {
        return "user/movie";
    }

    @RequestMapping("/pick-chair")
    public String showChair() {
        return "user/pick-chair";
    }

    @RequestMapping("/product")
    public String showProduct() {
        return "user/product";
    }

    @RequestMapping("/registered")
    public String showRegister(Model model) {
        model.addAttribute("newKhachHang", new KhachHang());
        return "user/registered";
    }

    @RequestMapping(value = "/registered/save", method = RequestMethod.POST)
    public String getRegister(Model model, @ModelAttribute("newKhachHang") KhachHang khachHang) {
        this.khachHangService.saveKhachHang(khachHang);
        return "redirect:/login";
    }

}
