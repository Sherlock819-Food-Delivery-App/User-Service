package com.example.User.dataloader;

import com.example.User.model.User;
import com.example.User.repo.UserRepo;
import jakarta.annotation.PostConstruct;
import org.example.utils.EmailGenerator;
import org.example.utils.MobileNumberGenerator;
import org.example.utils.NameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataLoader {

    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    public void loadData() {
        int numberOfRecords = 10;
        long id = userRepo.count() + 1;
        for (int i = 0; i < numberOfRecords; i++, id++) {
            String[] name = NameGenerator.generateRandomName().split(" ");
            userRepo.save(User.builder()
                    .userId(id)
                    .firstName(name[0])
                    .lastName(name[1])
                    .mobile(MobileNumberGenerator.generateMobileNumber())
                    .email(EmailGenerator.generateRandomEmail())
                    .address(id + " Fake Street")
                    .isEnabled(true)
                    .isEmailVerified(false)
                    .isMobileVerified(false)
                    .role("USER")
                    .build());
        }
    }
}
