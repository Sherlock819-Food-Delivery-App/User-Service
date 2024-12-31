package com.example.User.service;

import com.example.User.dto.RegistrationRequestDTO;
import com.example.User.dto.UserResponseDTO;
import com.example.User.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    String deleteUser();

    UserResponseDTO updateUserProfile(RegistrationRequestDTO registrationRequestDTO);

    User getUser();

    Boolean isAuthenticated();
}
