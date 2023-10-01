package com.userManagement.config;

import com.userManagement.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assuming user.getRole() returns a String representing the user's role
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
        return Collections.singleton(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        // Assuming user.getPassword() returns the user's password
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        // Assuming user.getEmail() returns the user's email or username

        return user.getUserEmail();

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // You can add logic here to check if the user is enabled or not
        // For example, return user.isEnabled();
        return true;
    }
}
