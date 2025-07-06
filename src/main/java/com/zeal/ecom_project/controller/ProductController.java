package com.zeal.ecom_project.controller;

import com.zeal.ecom_project.model.Product;
import com.zeal.ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet(){
        return "hello ";
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return service.getAllProduct();
    }


}
