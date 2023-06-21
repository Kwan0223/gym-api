package com.best.kwan.validation;


import com.best.kwan.eums.ErrorCode;
import com.best.kwan.exception.CustomException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String>  {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        boolean matchesPattern = value.matches("^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[!\"#$%&'()*+,./:;<=>?@^_`{|}~-]).{8,}$");

        return matchesPattern;
    }


}