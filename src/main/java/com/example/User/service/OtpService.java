package com.example.User.service;

public interface OtpService {
    String validateOtpForEmail(String email, String otp);

    void generateAndSendOtp(String identifier, String role, Boolean isEmail);
}
