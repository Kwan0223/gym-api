package com.best.kwan.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {

    String message() default "비밀번호는 대문자, 소문자, 숫자, 특수문자중 3가지를 포함해야합니다.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
