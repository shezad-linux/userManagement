package com.userManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userManagement.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

    // Check if a user with a given email exists
    boolean existsByUserEmail(String userEmail);


    // Find a user by email
    User  findByUserEmail(String userEmail);



}
