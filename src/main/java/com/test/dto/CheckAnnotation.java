package com.test.dto;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CheckValidation.class)
@Target({ FIELD, METHOD, CONSTRUCTOR, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface CheckAnnotation {

    String message() default "{Some message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
