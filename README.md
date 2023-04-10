# New-Age-Pets
![Logo](https://github.com/Miracle225/New-Age-Pets/blob/master/src/main/resources/static/images/logo.png)

## Description
This repo created for e-commerce pet shop site in studying targets. This is my first serious project using Spring Boot. I have used **Spring Boot, Spring Security, Lombok framework, Spring Data JPA** with **MySQL Database,** for views i have used **HTML** and **CSS** and some **Bootstrap** CSS framework.

## Screeenshots
**Home Page**
![Site home page.](https://github.com/Miracle225/New-Age-Pets/blob/master/src/main/resources/static/images/Home%20Page.png)

**Categories**
![Categories.](https://github.com/Miracle225/New-Age-Pets/blob/master/src/main/resources/static/images/Categories.png)

**Login page**
![Login.](https://github.com/Miracle225/New-Age-Pets/blob/master/src/main/resources/static/images/Login.png)

**Registration page**
![Registration](https://github.com/Miracle225/New-Age-Pets/blob/master/src/main/resources/static/images/Registration.png)

**Products page**
![Products.](https://github.com/Miracle225/New-Age-Pets/blob/master/src/main/resources/static/images/Products.png)

**Product page**
![Product.](https://github.com/Miracle225/New-Age-Pets/blob/master/src/main/resources/static/images/Product.png)

**Cart Page**
![Cart.](https://github.com/Miracle225/New-Age-Pets/blob/master/src/main/resources/static/images/Cart.png)

## Instalation
First you should do clean installation:
```
$ mvn clean install
```
You can start application using Spring Boot custom command:
```
$ mvn spring-boot:run
```
## Logins
There are two users in Database:

Login: `admin` Password: `admin` with **ADMIN** role.

Login: `user` Password: `user` with **USER** role.

## Roles

**ADMIN** can add, edit and delete products.

**USER** can view products, view products by category, search products and add products to shopping cart to buy them.
