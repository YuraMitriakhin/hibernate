package com.gmail.yuramitryahin.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements
        ConstraintValidator<EmailValidation, String> {
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    @Override
    public boolean isValid(String emailField,
                           ConstraintValidatorContext cxt) {
        return emailField != null && emailField.matches(EMAIL_REGEX)
                && (emailField.length() > 4) && (emailField.length() < 30);
    }
}
