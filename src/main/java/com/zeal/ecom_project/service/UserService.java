package com.zeal.ecom_project.service;

import com.zeal.ecom_project.dto.ApiResponse;
import com.zeal.ecom_project.dto.UserRegisterDto;
import com.zeal.ecom_project.model.Customer;
import com.zeal.ecom_project.model.Role;
import com.zeal.ecom_project.model.Users;
import com.zeal.ecom_project.repository.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public ResponseEntity<ApiResponse<Users>> register(UserRegisterDto dto) {
        if (userRepo.existsByUsername(dto.getUsername())){
            ApiResponse<Users> response = new ApiResponse<>("Username Already Exist",null);
            return ResponseEntity.ok(response);
        }
        Users users = new Users();
        users.setUsername(dto.getUsername());
        users.setPassword(dto.getPassword());
        users.setRole(dto.getRole());

        if (Role.CUSTOMER.equals(users.getRole())){
            Customer customer = new Customer();
            customer.setName(dto.getName());
            customer.setContact(dto.getContact());
            customer.setAddress(dto.getAddress());
            customer.setUser(users);
            users.setCustomer(customer);
            entityManager.persist(customer);
        }
        Users savedUser = userRepo.save(users);
        ApiResponse<Users> response = new ApiResponse<>("Username Already Exist",savedUser);
        return ResponseEntity.ok(response);
    }
}
