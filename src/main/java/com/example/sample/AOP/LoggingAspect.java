package com.example.sample.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.sample.ServiceImpl.*.*(..))")
    public void userServiceMethods() {}

    @Before("userServiceMethods()")
    public void logMethodStart(JoinPoint joinPoint) {
        log.info("Entering method: {} with argument: {}",
            joinPoint.getSignature().toShortString(),
            joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "userServiceMethods()", returning = "result")
    public void logMethodEnd(JoinPoint joinPoint, Object result) {
        log.info("Exiting method: {} with result: {}",
                joinPoint.getSignature().toShortString(),
                result);
    }

    @AfterThrowing(pointcut = "userServiceMethods()", throwing = "ex")
    public void logMethodException(JoinPoint joinPoint, Throwable ex) {
        log.error("Exception in method: {} with message: {}",
                joinPoint.getSignature().toShortString(),
                ex.getMessage(), ex);
    }

    @Around("userServiceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long duration = System.currentTimeMillis() -start;
        log.info("Execution time of {} : {} ms",
                joinPoint.getSignature().toShortString(),
                duration);
        return proceed;
    }


}
