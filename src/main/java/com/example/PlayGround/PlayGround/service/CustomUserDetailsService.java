package com.example.PlayGround.PlayGround.service;

import com.example.PlayGround.PlayGround.model.User;
import com.example.PlayGround.PlayGround.model.UserPrincipal;
import com.example.PlayGround.PlayGround.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Fetch the user by email from the repository
        User user = userRepo.findByEmail(email);

        if (user == null)
            throw new UsernameNotFoundException("User not found with email: " + email);

        // Return an instance of CustomUserDetails
        return new UserPrincipal(user);
    }
}
