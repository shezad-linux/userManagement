package com.userManagement.controller;

import javax.servlet.http.HttpSession;

import com.userManagement.model.User;
import com.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class HomeController {

    @Autowired
   private UserService userService;
    @GetMapping("/")
    public String index(){

        return "index";
    }


    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(){

        return "register";

}
    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user, HttpSession session) {
        boolean f = userService.checkEmail(user.getUserEmail());


        if (f) {
            session.setAttribute("msg","You are already registered, please login");
        } else {
            User userDetails = userService.createUser(user);
            if (userDetails != null) {
                session.setAttribute("msg","registration succesfull");
            } else {
                session.setAttribute("msg","failed to register, something went wrong");

            }


        }
        return "redirect:/register";
    }

}