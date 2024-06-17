package com.wonically.crudent.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public void initialize(PhoneNumber phoneNumber) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber.matches("^(\\+([1-9]?){2}[1-9]\\s)?\\([0-9]{3}\\)\\s[0-9]{3}-[0-9]{4}$")) {
            return true; //validate optional country code +xxx with (xxx) xxx-xxxx
        } else if (phoneNumber.matches("(\\+([1-9]?){2}[1-9]\\s)?[0-9]{3}(-[0-9]{3}-|[0-9]{3})[0-9]{4}")) {
            return true; //validate optional country code +xxx with xxx-xxx-xxxx or xxxxxxxxxx (first number can be 0)
        } else return phoneNumber.matches("(\\+([1-9]?){2}[1-9]\\s)?[1-9][0-9]{2}(-[0-9]{3}-|[0-9]{3})[0-9]{3}"); //validate optional country code +xxx with xxx-xxx-xxx or xxxxxxxxx (first number cannot be 0)
    }
}
