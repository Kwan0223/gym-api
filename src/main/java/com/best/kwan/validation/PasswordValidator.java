package com.best.kwan.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) {
            return false;
        }

        return value.matches("^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[!\"#$%&'()*+,./:;<=>?@^_`{|}~-]).{8,}$");
    }

}