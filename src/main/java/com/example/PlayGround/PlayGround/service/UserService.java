package com.example.PlayGround.PlayGround.service;

import com.example.PlayGround.PlayGround.dto.RegistrationRequestDTO;
import com.example.PlayGround.PlayGround.dto.UserResponseDTO;
import com.example.PlayGround.PlayGround.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    String deleteUser();

    UserResponseDTO updateUserProfile(RegistrationRequestDTO registrationRequestDTO);

    User getUser();

    Boolean isAuthenticated();
}
