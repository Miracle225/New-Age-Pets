package com.InternetShop.shop;


import com.InternetShop.shop.Models.Category;
import com.InternetShop.shop.Models.Gender;
import com.InternetShop.shop.Models.Product;
import com.InternetShop.shop.Models.User;
import com.InternetShop.shop.Services.ProductService;
import com.InternetShop.shop.Services.UserService;
import com.InternetShop.shop.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.UUID;


@Component
public class StartUpData implements CommandLineRunner {
    private UserService userService;
    private ProductService productService;
    private CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(StartUpData.class);

    @Autowired
    public void StartupData(UserService userService, ProductService productService, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        //adminAccount();
       // userAccount();
        //category();
        //exampleProducts();
    }

    private void userAccount(){
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender(Gender.FEMALE);
        user.setEmail("user@example.com");

        userService.save(user);
    }

    private void adminAccount(){
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPasswordConfirm("admin");
        admin.setGender(Gender.MALE);
        admin.setEmail("admin@example.com");

        userService.save(admin);
    }

    private void category(){
        Category category1 = new Category();
        Category category2 = new Category();
        category1.setId(UUID.randomUUID());
        category1.setCategoryName("Dogs");
        category1.setUrl("https://upload.wikimedia.org/wikipedia/commons/0/0c/About_The_Dog.jpg");
        category2.setId(UUID.randomUUID());
        category2.setCategoryName("Cats");
        category2.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQz7qkv3rOFYnFxI37vW0hn2TK_vtK7z-vo7g&usqp=CAU");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
    }

    private void exampleProducts(){
        final String NAME = "Example Name";
        final String PICTURE_URL = "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX7389458.jpg";
        final String DESCRIPTION = "Example Description";
        final BigDecimal PRICE = BigDecimal.valueOf(50);

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();
        Product product6 = new Product();
        Product product7 = new Product();
        Product product8 = new Product();
        Product product9 = new Product();
        Product product10 = new Product();

        product1.setName(NAME);
        product1.setPictureUrl(PICTURE_URL);
        product1.setDescription(DESCRIPTION);
        product1.setCategory(categoryRepository.findByCategoryName("Dogs"));
        product1.setPrice(PRICE);
        product1.setQuantity(10);

        product2.setName(NAME);
        product2.setPictureUrl(PICTURE_URL);
        product2.setDescription(DESCRIPTION);
        product2.setCategory(categoryRepository.findByCategoryName("Cats"));
        product2.setPrice(PRICE);
        product2.setQuantity(10);

        product3.setName(NAME);
        product3.setPictureUrl(PICTURE_URL);
        product3.setDescription(DESCRIPTION);
        product3.setCategory(categoryRepository.findByCategoryName("Dogs"));
        product3.setPrice(PRICE);
        product3.setQuantity(10);

        product4.setName(NAME);
        product4.setPictureUrl(PICTURE_URL);
        product4.setDescription(DESCRIPTION);
        product4.setCategory(categoryRepository.findByCategoryName("Cats"));
        product4.setPrice(PRICE);
        product4.setQuantity(10);

        product5.setName(NAME);
        product5.setPictureUrl(PICTURE_URL);
        product5.setDescription(DESCRIPTION);
        product5.setCategory(categoryRepository.findByCategoryName("Dogs"));
        product5.setPrice(PRICE);
        product5.setQuantity(10);

        product6.setName(NAME);
        product6.setPictureUrl(PICTURE_URL);
        product6.setDescription(DESCRIPTION);
        product6.setCategory(categoryRepository.findByCategoryName("Cats"));
        product6.setPrice(PRICE);
        product6.setQuantity(10);

        product7.setName(NAME);
        product7.setPictureUrl(PICTURE_URL);
        product7.setDescription(DESCRIPTION);
        product7.setCategory(categoryRepository.findByCategoryName("Dogs"));
        product7.setPrice(PRICE);
        product7.setQuantity(10);

        product8.setName(NAME);
        product8.setPictureUrl(PICTURE_URL);
        product8.setDescription(DESCRIPTION);
        product8.setCategory(categoryRepository.findByCategoryName("Cats"));
        product8.setPrice(PRICE);
        product8.setQuantity(10);

        product9.setName(NAME);
        product9.setPictureUrl(PICTURE_URL);
        product9.setDescription(DESCRIPTION);
        product9.setCategory(categoryRepository.findByCategoryName("Dogs"));
        product9.setPrice(PRICE);
        product9.setQuantity(10);

        product10.setName(NAME);
        product10.setPictureUrl(PICTURE_URL);
        product10.setDescription(DESCRIPTION);
        product10.setCategory(categoryRepository.findByCategoryName("Cats"));
        product10.setPrice(PRICE);
        product10.setQuantity(0);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
        productService.save(product5);
        productService.save(product6);
        productService.save(product7);
        productService.save(product8);
        productService.save(product9);
        productService.save(product10);

    }

    public static void main(String[] args) {

    }
}
