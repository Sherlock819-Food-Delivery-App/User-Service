package com.example.User.controller;

import com.example.User.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userdetails")
public class CustomUserDetailsController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/{email}")
    public UserDetails getUserDetails(@PathVariable String email) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
        return userDetails;
    }
}
