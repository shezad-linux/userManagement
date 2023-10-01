package com.userManagement.controller;

import com.userManagement.model.User;
import com.userManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserRepository userRepo;
    @ModelAttribute
    private void userDetails(Model m, Principal p) {
        String userEmail= p.getName();
        User user = userRepo.findByUserEmail(userEmail);

        m.addAttribute("user", user);

    }
    @GetMapping("/")
    public String Home(){
        return "user/home";
    }


}
