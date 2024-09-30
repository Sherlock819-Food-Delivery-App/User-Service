package com.example.PlayGround.PlayGround.DataLoader;

import com.example.PlayGround.PlayGround.DTO.User;
import com.example.PlayGround.PlayGround.Repo.UserRepo;
import com.example.PlayGround.PlayGround.Utilities.EmailGenerator;
import com.example.PlayGround.PlayGround.Utilities.MobileNumberGenerator;
import com.example.PlayGround.PlayGround.Utilities.NameGenerator;
import org.springframework.beans.factory.annotation.Autowired;

public class DataLoader {

    @Autowired
    private UserRepo userRepo;

    public void loadData() {
        int numberOfRecords = 10;
        long id = userRepo.count()+1;
        for (int i = 0; i < numberOfRecords; i++, id++) {
            String[] name = NameGenerator.generateRandomName().split(" ");
            userRepo.save(new User(id, name[0], name[1], MobileNumberGenerator.generateMobileNumber(), EmailGenerator.generateRandomEmail()));
        }
    }

    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();
        dataLoader.loadData();
    }
}
