package com.zeal.ecom_project.controller;

import com.zeal.ecom_project.dto.ApiResponse;
import com.zeal.ecom_project.dto.UserRegisterDto;
import com.zeal.ecom_project.model.Users;
import com.zeal.ecom_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/register")
    public ResponseEntity<ApiResponse<Users>> register(@RequestBody UserRegisterDto dto){
        return userService.register(dto);
    }

}
