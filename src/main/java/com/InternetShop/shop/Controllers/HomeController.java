package com.InternetShop.shop.Controllers;

import com.InternetShop.shop.Models.Product;
import com.InternetShop.shop.Services.CategoryService;
import com.InternetShop.shop.Services.ProductService;
import com.InternetShop.shop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
public class HomeController {
    private final ProductService productService;


    @Autowired
    private CategoryService categoryService;

    @Autowired
    public HomeController(ProductService productService,UserService userService) {
        this.productService = productService;
    }

    @GetMapping(value = {"/","/index","/home"})
    public String home(Model model){
        UUID id = UUID.fromString("61fa2de0-0ce6-4cd8-aba0-29b02d0878fc");
        Product offerProduct = productService.findById(id).get();
        model.addAttribute("offerProduct",offerProduct);
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
//    @GetMapping("/home/search")
//    public String searchProducts(Model model){
//        String searchTemplate="";
//        model.addAttribute("searchTemplate",searchTemplate);
//        return "home";
//    }

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
