package com.QuanLyRap.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String getHomePage() {
        return "user/index";
    }

    @GetMapping("/about-us")
    public String showAboutUs() {
        return "user/about-us";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "user/login";
    }

    @GetMapping("/movie")
    public String showMovie() {
        return "user/movie";
    }

    @GetMapping("/pick-chair")
    public String showChair() {
        return "user/pick-chair";
    }

    @GetMapping("/product")
    public String showProduct() {
        return "user/product";
    }

    @GetMapping("/registered")
    public String showRegistered() {
        return "user/registered";
    }
}
