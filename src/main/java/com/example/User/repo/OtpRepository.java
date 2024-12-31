package com.example.User.repo;

import com.example.User.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface OtpRepository extends JpaRepository<Otp, Long> {

    Otp findByEmail(String email);

    Otp findByEmailAndOtp(String email, String otp);

    Otp findByMobileAndOtp(String email, String otp);

    Otp findByMobile(String email);

    void deleteByExpirationTimeBefore(LocalDateTime now);
}