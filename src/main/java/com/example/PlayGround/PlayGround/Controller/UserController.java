package com.example.PlayGround.PlayGround.Controller;

import com.example.PlayGround.PlayGround.DTO.User;
import com.example.PlayGround.PlayGround.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/addUser")
    public String createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/updateUser")
    public String updateCustomer(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
