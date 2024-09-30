package com.example.PlayGround.PlayGround.Service;

import com.example.PlayGround.PlayGround.DTO.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    String save(User user);

    User getUser(Long userId);

    String updateUser(User user);
}
