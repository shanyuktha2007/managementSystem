
package com.example.managementsystem.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    private static final Logger logger =
            LoggerFactory.getLogger(AuditAspect.class);

    @Around("execution(* com.example.managementsystem.service.EmployeeService.*(..))")
    public Object auditEmployeeOperations(
            ProceedingJoinPoint joinPoint) throws Throwable {

        String method = joinPoint.getSignature().getName();

        logger.info("AUDIT START: {}", method);

        try {
            Object result = joinPoint.proceed();
            logger.info("AUDIT SUCCESS: {}", method);
            return result;
        } catch (Throwable exception) {
            logger.error("AUDIT FAILURE: {}", method);
            throw exception;
        }
    }
}
