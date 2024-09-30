package com.example.PlayGround.PlayGround.Service;

import com.example.PlayGround.PlayGround.DTO.User;
import com.example.PlayGround.PlayGround.Exception.InValidElementException;
import com.example.PlayGround.PlayGround.Exception.NoSuchElementExistsException;
import com.example.PlayGround.PlayGround.Exception.ElementAlreadyExistsException;
import com.example.PlayGround.PlayGround.Repo.UserRepo;
import com.example.PlayGround.PlayGround.Utilities.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Validator validator;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public String save(User user) {
        User existingUser
                = userRepo.findByUserIdOrMobileOrEmail(user.getUserId(), user.getMobile(), user.getEmail());
        if (existingUser == null) {
            this.validateUser(user);
            userRepo.save(user);
            return "Customer added successfully";
        } else if (existingUser.getMobile().equals(user.getMobile())) {
            throw new ElementAlreadyExistsException(
                    "Mobile number already registered!!");
        } else if (existingUser.getEmail().equals(user.getEmail()))
            throw new ElementAlreadyExistsException(
                    "Email address already registered!!");
        else
            throw new ElementAlreadyExistsException(
                    "User already registered!!");
    }

    @Override
    public User getUser(Long userId) {
        return userRepo.findById(userId).orElseThrow(
                () -> new NoSuchElementException(
                        "NO CUSTOMER PRESENT WITH ID = " + userId));
    }

    @Override
    public String updateUser(User user) {
        User existingUser
                = userRepo.findById(user.getUserId())
                .orElse(null);
        User existingUserByMobileOrEmail
                = userRepo.findByMobileOrEmail(user.getMobile(), user.getEmail());
        if (existingUser == null)
            throw new NoSuchElementExistsException(
                    "No Such User exists!!");
        else {
            if (existingUserByMobileOrEmail != null && existingUserByMobileOrEmail.getUserId() != user.getUserId()) {
                if (existingUserByMobileOrEmail.getMobile().equals(user.getMobile()))
                    throw new ElementAlreadyExistsException(
                            "Mobile number already registered!!");
                if (existingUserByMobileOrEmail.getEmail().equals(user.getEmail()))
                    throw new ElementAlreadyExistsException(
                            "Email address already registered!!");
            }
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setMobile(user.getMobile());
            existingUser.setEmail(user.getEmail());
            userRepo.save(existingUser);
            return "Record updated Successfully";
        }
    }


    private void validateUser(User user) {
        if (user.getUserId() < 0) {
            throw new InValidElementException(
                    "Employee Id cannot be below 0.");
        }
        if (!validator.isValidName(user.getFirstName())) {
            throw new InValidElementException(
                    "First name must only contains alphabets. Invalid entry - {" + user.getFirstName() + "}");
        }
        if (!validator.isValidName(user.getLastName())) {
            throw new InValidElementException(
                    "Last name must only contains alphabets. Invalid entry - {" + user.getLastName() + "}");
        }
        if (!validator.isValidMobileNumber(user.getMobile())) {
            throw new InValidElementException(
                    "Mobile number must only contain 10 digits. Invalid entry - {" + user.getMobile() + "}");
        }
        if (!validator.isValidEmailAddress(user.getEmail())) {
            throw new InValidElementException(
                    "Email address must only contain 10 digits. Invalid entry - {" + user.getEmail() + "}");
        }
    }
}
