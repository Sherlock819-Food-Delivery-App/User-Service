package com.example.PlayGround.PlayGround.Utilities;

import java.util.Random;

public class NameGenerator {

    private static final String[] FIRST_NAMES = {
            "Alice", "Bob", "Charlie", "Diana", "Ethan", "Fiona", "George", "Hannah", "Isaac", "Julia"
    };

    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"
    };

    public static String generateRandomName() {
        Random random = new Random();

        // Select a random first name
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

        // Select a random last name
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];

        // Combine first name and last name
        return firstName + " " + lastName;
    }

    public static void main(String[] args) {
        String randomName = generateRandomName();
        System.out.println("Generated Random Name: " + randomName);
    }
}

