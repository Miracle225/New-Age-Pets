package com.InternetShop.shop.Controllers;

import com.InternetShop.shop.Models.User;
import com.InternetShop.shop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String login(Model model, String error) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        return "login";
    }

//    boolean userFound = true;
//    private final UserService userService;
//@Autowired
//public LoginController(UserService userService) {
//    this.userService = userService;
//}
//    @GetMapping("/account-recovery")
//    public String accountRecovery(Model model, String error) {
//        String email = "";
//        model.addAttribute("flag", userFound);
//        model.addAttribute("email", email);
//        return "account-recovery";
//    }
//
//    @PostMapping("/account-recovery")
//    public String accountRecovery(@ModelAttribute("email") String email, Model model) {
//        List<User> users = userService.findAll();
//        for (User user : users) {
//            if (user.getEmail().equals(email)) {
//                return "login";
//            }
//        }
//        userFound = false;
//        return "account-recovery";
//    }
}