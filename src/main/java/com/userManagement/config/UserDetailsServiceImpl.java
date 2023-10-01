package com.userManagement.config;

import com.userManagement.model.User;
import com.userManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        User user = userRepo.findByUserEmail(userEmail); // Using findByUserEmail based on naming conventions


        if (user != null) { System.out.println(user);
            return new CustomUserDetails(user);

        }

        throw new UsernameNotFoundException("User not available");

    }

}