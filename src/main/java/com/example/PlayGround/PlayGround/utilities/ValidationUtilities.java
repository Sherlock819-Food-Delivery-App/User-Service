package com.example.PlayGround.PlayGround.utilities;

import org.example.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtilities extends Validator {
    private String cleanup(String data)
    {
        return data.trim();
    }
}
