package com.InternetShop.shop.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Principal principal,Model model, String error){
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        return "login";
    }
}