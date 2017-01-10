package com.test.dto;

import com.test.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CheckValidation implements ConstraintValidator<CheckAnnotation, User> {


    @Override
    public void initialize(CheckAnnotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if (PasswordUtil.hasNumberUpperLowerLetter(user.getPassword()) &&
                PasswordUtil.hasNoMoreThanThreeCharacter(user.getPassword()) &&
                PasswordUtil.hasLessThanThreeSameCharacter(user.getPassword())){
            return true;
        }
        return false;
    }
}
