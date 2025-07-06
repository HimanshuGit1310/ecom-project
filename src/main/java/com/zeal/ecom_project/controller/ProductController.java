package com.zeal.ecom_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @RequestMapping("/")
    public String greet(){
        return "hello ";
    }


}
