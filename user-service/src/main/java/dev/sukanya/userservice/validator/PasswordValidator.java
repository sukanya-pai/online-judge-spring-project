package dev.sukanya.userservice.validator;


import dev.sukanya.userservice.annotations.PasswordConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements
        ConstraintValidator<PasswordConstraint, String> {

    @Override
    public void initialize(PasswordConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String password,
                           ConstraintValidatorContext cxt) {
        boolean isValid = password != null && password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{4,20}$");
        return isValid ;
    }

}