package com.zeal.ecom_project.dto;

import com.zeal.ecom_project.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserRegisterDto {

    //common
    private String username;
    private String password;
    private Role role;

    //customer
    private String name;
    private String contact;
    private String address;
}
