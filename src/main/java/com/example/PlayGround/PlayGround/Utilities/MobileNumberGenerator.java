package com.example.PlayGround.PlayGround.Utilities;

import java.util.Random;

public class MobileNumberGenerator {

    public static String generateMobileNumber() {
        Random random = new Random();
        StringBuilder mobileNumber = new StringBuilder();

        // Generate the first digit (must be between 7 and 9)
        int firstDigit = random.nextInt(3) + 7; // 7, 8, or 9
        mobileNumber.append(firstDigit);

        // Generate the remaining 9 digits
        for (int i = 1; i < 10; i++) {
            int digit = random.nextInt(10); // 0 to 9
            mobileNumber.append(digit);
        }

        return mobileNumber.toString();
    }

    public static void main(String[] args) {
        String mobileNumber = generateMobileNumber();
        System.out.println("Generated Mobile Number: " + mobileNumber);
    }
}
