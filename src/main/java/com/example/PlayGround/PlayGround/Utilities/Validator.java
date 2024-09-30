package com.example.PlayGround.PlayGround.Utilities;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator {
    private String cleanup(String data)
    {
        return data.trim();
    }

    public boolean isValidName(String name) {
        // Regular expression to check if the name contains only letters (case insensitive)

        return name != null && name.matches("[a-zA-Z]+");
    }

    public boolean isValidMobileNumber(String mobileNumber) {
        // You can customize the pattern to match your specific requirements
        String regex = "^\\d{10}$"; // For a 10-digit mobile number
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }

    public boolean isValidEmailAddress(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
