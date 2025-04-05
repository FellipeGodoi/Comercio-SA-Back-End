//package br.com.muralis.comercio.exception.annotation;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//
//import java.lang.annotation.*;
//
//@Documented
//@Constraint(validatedBy = UniqueValueValidator.class)
//@Target({ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//public @interface UniqueValue {
//    String message() default "Valor já está em uso";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//
//    String fieldName();
//    Class<?> domainClass();
//}
