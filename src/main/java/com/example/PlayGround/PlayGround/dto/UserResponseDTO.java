package com.example.PlayGround.PlayGround.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String address;
    private String role;
}