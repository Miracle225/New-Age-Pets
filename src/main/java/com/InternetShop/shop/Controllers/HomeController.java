package com.InternetShop.shop.Controllers;

import com.InternetShop.shop.Models.Product;
import com.InternetShop.shop.Models.User;
import com.InternetShop.shop.Services.CategoryService;
import com.InternetShop.shop.Services.ProductService;
import com.InternetShop.shop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.UUID;


@Controller
public class HomeController {
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    public HomeController(ProductService productService,UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping(value = {"/","/index","/home"})
    public String home(Model model){
        model.addAttribute("products", getAllProducts());
        model.addAttribute("categories", categoryService.findAll());
        return "home";
    }

    @RequestMapping("/searchByCategory")
    public String homePost(@RequestParam("categoryId") UUID categoryId, Model model){
        model.addAttribute("products", productService.findAllByCategory(categoryId));
        model.addAttribute("productsCount", productService.count());
        model.addAttribute("categories", categoryService.findAll());
        return "home";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact-us")
    public String contactUs(){
        return "contact-us";
    }

    private List<Product> getAllProducts(){
        return productService.findAll();
    }

}
