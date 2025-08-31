package com.example.sample.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    private String getCurrentUserROle() {
        return "ADMIN";
    }

    @Around("@annotation(com.example.sample.Validation.Admin)")
    public Object checkAdminRole(ProceedingJoinPoint joinPoint) throws Throwable {

        String role = getCurrentUserROle();

        if (!"ADMIN".equals(role)) {
            throw new RuntimeException("Access denied: Admin Only");
        }
        return joinPoint.proceed();
    }

}
