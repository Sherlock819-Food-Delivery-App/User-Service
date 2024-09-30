package com.example.PlayGround.PlayGround.Utilities;

import java.util.Random;

public class EmailGenerator {

    private static final String[] DOMAIN_NAMES = {
            "hotmail.com", "orkut.com", "mail.com", "gmail.com", "yahoo.com", "outlook.com"
    };

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandomEmail() {
        Random random = new Random();
        StringBuilder email = new StringBuilder();

        // Generate a random username (6 to 12 characters long)
        int usernameLength = random.nextInt(7) + 6; // Length between 6 and 12
        for (int i = 0; i < usernameLength; i++) {
            int index = random.nextInt(CHARACTERS.length());
            email.append(CHARACTERS.charAt(index));
        }

        // Append '@' and a random domain
        email.append("@").append(DOMAIN_NAMES[random.nextInt(DOMAIN_NAMES.length)]);

        return email.toString();
    }

    public static void main(String[] args) {
        String randomEmail = generateRandomEmail();
        System.out.println("Generated Random Email: " + randomEmail);
    }
}
