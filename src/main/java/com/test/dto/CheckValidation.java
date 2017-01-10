package com.test.dto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.ANNOTATED_ELEMENT)
public class CheckValidation implements ConstraintValidator<CheckAnnotation, String> {


    @Override
    public void initialize(CheckAnnotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return PasswordUtil.hasNumberUpperLowerLetter(password) &&
                PasswordUtil.hasNoMoreThanThreeCharacter(password) &&
                PasswordUtil.hasLessThanThreeSameCharacter(password);
    }
}
