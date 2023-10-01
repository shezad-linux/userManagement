package com.userManagement.service;

import com.userManagement.model.User;

public interface UserService {
    public User createUser(User user);
    public  boolean checkEmail(String userEmail);
}
