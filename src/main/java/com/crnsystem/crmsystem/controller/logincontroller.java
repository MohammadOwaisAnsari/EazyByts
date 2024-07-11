package com.crnsystem.crmsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class logincontroller {

    @GetMapping("/login")
    public String showLoginPage() {
        return "index";
    }

    @PostMapping("/login")
    public String handleLogin(String username, String password) {
        // Add authentication logic here
        if (username.equals("admin") && password.equals("password")) {
            return "redirect:/dashboard";
        }
        return "redirect:/login?error";
    }
}
