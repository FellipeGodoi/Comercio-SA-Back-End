//package br.com.muralis.comercio.exception.annotation;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
//
//    private String fieldName;
//    private Class<?> domainClass;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public void initialize(UniqueValue constraintAnnotation) {
//        fieldName = constraintAnnotation.fieldName();
//        domainClass = constraintAnnotation.domainClass();
//    }
//
//    @Override
//    public boolean isValid(Object value, ConstraintValidatorContext context) {
//        if (value == null) return true;
//
//        try {
//            String entityName = domainClass.getSimpleName();
//
//            String jpql = "SELECT COUNT(e) FROM " + entityName +
//                    " e WHERE e." + fieldName + " = :value";
//
//            Long count = entityManager.createQuery(jpql, Long.class)
//                    .setParameter("value", value)
//                    .getSingleResult();
//
//            return count == 0;
//        } catch (Exception e) {
//            System.err.println("Erro na validação @UniqueValue: " + e.getMessage());
//            return false;
//        }
//    }
//}