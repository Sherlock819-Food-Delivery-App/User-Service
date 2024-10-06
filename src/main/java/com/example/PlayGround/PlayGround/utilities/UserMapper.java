package com.example.PlayGround.PlayGround.utilities;

import com.example.PlayGround.PlayGround.dto.UserResponseDTO;
import com.example.PlayGround.PlayGround.model.User;
import org.example.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setMobile(user.getMobile());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        userDto.setRole(user.getRole());
        return userDto;
    }

    public List<UserDto> toDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        int count = 0;
        for(User user : users) {
            userDtos.add(new UserDto());
            userDtos.get(count).setUserId(user.getUserId());
            userDtos.get(count).setFirstName(user.getFirstName());
            userDtos.get(count).setLastName(user.getLastName());
            userDtos.get(count).setMobile(user.getMobile());
            userDtos.get(count).setEmail(user.getEmail());
            userDtos.get(count).setAddress(user.getAddress());
            userDtos.get(count).setRole(user.getRole());;
            count++;
        }
        return userDtos;
    }

    public UserResponseDTO toResponseDto(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(user.getUserId());
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setMobile(user.getMobile());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setAddress(user.getAddress());
        userResponseDTO.setRole(user.getRole());
        return userResponseDTO;
    }

    public List<UserResponseDTO> toResponseDto(List<User> users) {
        List<UserResponseDTO> userResponseDTOs = new ArrayList<>();
        int count = 0;
        for(User user : users) {
            userResponseDTOs.add(new UserResponseDTO());
            userResponseDTOs.get(count).setUserId(user.getUserId());
            userResponseDTOs.get(count).setFirstName(user.getFirstName());
            userResponseDTOs.get(count).setLastName(user.getLastName());
            userResponseDTOs.get(count).setMobile(user.getMobile());
            userResponseDTOs.get(count).setEmail(user.getEmail());
            userResponseDTOs.get(count).setAddress(user.getAddress());
            userResponseDTOs.get(count).setRole(user.getRole());
            count++;
        }
        return userResponseDTOs;
    }

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setMobile(userDto.getMobile());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public List<User> toEntity(List<UserDto> userDtos) {
        List<User> users = new ArrayList<>();
        int count = 0;
        for(UserDto userDto : userDtos) {
            users.add(new User());
            users.get(count).setUserId(userDto.getUserId());
            users.get(count).setFirstName(userDto.getFirstName());
            users.get(count).setFirstName(userDto.getLastName());
            users.get(count).setMobile(userDto.getMobile());
            users.get(count).setEmail(userDto.getEmail());
        }

        return users;
    }
}
