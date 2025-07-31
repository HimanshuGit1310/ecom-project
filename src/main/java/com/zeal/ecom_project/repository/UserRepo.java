package com.zeal.ecom_project.repository;

import com.zeal.ecom_project.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{
    boolean existsByUsername(String username);
}
