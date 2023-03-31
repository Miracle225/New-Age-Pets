package com.InternetShop.shop.Controllers;

import com.InternetShop.shop.Models.Product;
import com.InternetShop.shop.Models.UserRole;
import com.InternetShop.shop.Services.CategoryService;
import com.InternetShop.shop.Services.ProductService;
import com.InternetShop.shop.validator.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final ProductValidator productValidator;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService,
                             ProductValidator productValidator,
                             CategoryService categoryService) {
        this.productService = productService;
        this.productValidator = productValidator;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public String products(Model model) {
        UserRole admin = UserRole.ADMIN;
        model.addAttribute("admin",admin);
        model.addAttribute("products", getAllProducts());
        return "products";
    }
    @RequestMapping("/products/search")
    public String getSearchProds(@RequestParam("search") String searchTemplate, Model model){
        List<Product> foundProds = productService.findAllBySearchKey(searchTemplate);
        model.addAttribute("searchQuery", searchTemplate);
        model.addAttribute("foundProds", foundProds);
        return "search-products";
    }


    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable UUID id, Model model) {
        Product product = productService.findById(id).get();
        model.addAttribute("product", product);
        model.addAttribute("products", getAllProducts());
        model.addAttribute("featuredProds", getFourProdForCategory(product.getCategory().getCategoryName()));
        return "product";
    }

    @GetMapping("products/{category}")
    public String getCategoryProducts(@PathVariable String category, Model model) {
        model.addAttribute("categoryProducts", getAllProductsByCategory(category));
        model.addAttribute("category", category);
        return "category-products";
    }

    @GetMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("productForm", new Product());
        model.addAttribute("method", "new");
        model.addAttribute("categories", categoryService.findAll());
        return "product-set";
    }

    @PostMapping("/product/new")
    public String newProduct(@ModelAttribute("productForm") Product productForm, BindingResult bindingResult, Model model) {
        //productValidator.validate(productForm, bindingResult);
        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "new");
            return "product-set";
        }

        productService.save(productForm);
        logger.debug(String.format("Product with id: %s successfully created.", productForm.getId()));

        return "redirect:/home";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") UUID productId, Model model) {
        Optional<Product> product = productService.findById(productId);
        if (product.isPresent()) {
            model.addAttribute("productForm", product.get());
            model.addAttribute("method", "edit");
            return "product-set";
        } else {
            return "error/404";
        }
    }

    @PostMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") UUID productId, @ModelAttribute("productForm") Product productForm, BindingResult bindingResult, Model model) {
        //productValidator.validate(productForm, bindingResult);
        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "edit");
            return "product-set";
        }
        productService.edit(productId, productForm);
        logger.debug(String.format("Product with id: %s has been successfully edited.", productId));

        return "redirect:/home";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") UUID productId) {
        Optional<Product> product = productService.findById(productId);
        if (product.isPresent()) {
            productService.delete(productId);
            logger.debug(String.format("Product with id: %s successfully deleted.", product.get().getId()));
            return "redirect:/home";
        } else {
            return "error/404";
        }
    }

    private List<Product> getAllProductsByCategory(String name) {
        return productService.findAllByCategoryName(name);
    }

    private List<Product> getAllProducts() {
        return productService.findAll();
    }

    private List<Product> getFourProdForCategory(String category) {
        int i = 4;
        List<Product> products = productService.findAll();
        List<Product> featuredProducts = new ArrayList<>(4);
        for (Product product : products) {
            if (product.getCategory().getCategoryName().equals(category)) {
                if (i > 0) {
                    featuredProducts.add(product);
                    i--;
                }
            }

        }
        return featuredProducts;
    }
}
