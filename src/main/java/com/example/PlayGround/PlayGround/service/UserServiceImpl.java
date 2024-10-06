package com.example.PlayGround.PlayGround.service;

import com.example.PlayGround.PlayGround.dto.RegistrationRequestDTO;
import com.example.PlayGround.PlayGround.dto.UserResponseDTO;
import com.example.PlayGround.PlayGround.model.User;
import com.example.PlayGround.PlayGround.repo.UserRepo;
import com.example.PlayGround.PlayGround.utilities.ValidationUtilities;
import org.example.exceptions.ElementAlreadyExistsException;
import org.example.exceptions.InValidElementException;
import org.example.exceptions.NoSuchElementExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ValidationUtilities validationUtilities;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User getUser() {
        User user = getPrincipalUser();

        if (user == null)
            throw new NoSuchElementException(
                    "User Not Found!!");
        return user;
    }

    @Override
    public UserResponseDTO updateUserProfile(RegistrationRequestDTO registrationRequest) {
        User principalUser = getPrincipalUser();

        if (principalUser == null)
            throw new NoSuchElementExistsException("User Not Found!");

        validateUser(registrationRequest);

        if (principalUser.getMobile() != null
                && !principalUser.getMobile().equals(registrationRequest.getMobile())) {
            if (userRepo.existsByMobile(registrationRequest.getMobile()))
                throw new ElementAlreadyExistsException(
                        "Mobile number already registered!!");
            else
                principalUser.setIsMobileVerified(false);
        }
        if (principalUser.getEmail() != null
                && principalUser.getEmail().equals(registrationRequest.getEmail())) {
            if (userRepo.existsByMobile(registrationRequest.getEmail()))
                throw new ElementAlreadyExistsException(
                        "Email address already registered!!");
            else
                principalUser.setIsEmailVerified(false);
        }

        principalUser.setFirstName(registrationRequest.getFirstName());
        principalUser.setLastName(registrationRequest.getLastName());
        principalUser.setEmail(registrationRequest.getEmail());
        principalUser.setMobile(registrationRequest.getMobile());
        principalUser.setEmail(registrationRequest.getEmail());
        principalUser.setAddress(registrationRequest.getAddress());
        principalUser.setRole("USER"); // Default role

        User savedUser = userRepo.save(principalUser);

        return new UserResponseDTO(
                savedUser.getUserId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail(),
                savedUser.getMobile(),
                savedUser.getAddress(),
                savedUser.getRole()
        );
    }

    @Override
    public String deleteUser() {
        User user = getPrincipalUser();
        if (user == null)
            throw new NoSuchElementExistsException("User Not Found!!");

        userRepo.delete(user);
        return "User deleted successfully";
    }

    private void validateUser(RegistrationRequestDTO user) {
        if (!validationUtilities.isValidName(user.getFirstName())) {
            throw new InValidElementException(
                    "First name must only contains alphabets. Invalid entry - {" + user.getFirstName() + "}");
        }
        if (!validationUtilities.isValidName(user.getLastName())) {
            throw new InValidElementException(
                    "Last name must only contains alphabets. Invalid entry - {" + user.getLastName() + "}");
        }
        if (!validationUtilities.isValidMobileNumber(user.getMobile())) {
            throw new InValidElementException(
                    "Mobile number must only contain 10 digits. Invalid entry - {" + user.getMobile() + "}");
        }
        if (!validationUtilities.isValidEmailAddress(user.getEmail())) {
            throw new InValidElementException(
                    "Email address must only contain 10 digits. Invalid entry - {" + user.getEmail() + "}");
        }
    }


    private User getPrincipalUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // fetch username
        return userRepo.findByEmail(username); // fetch user based on JWT token details
    }
}
