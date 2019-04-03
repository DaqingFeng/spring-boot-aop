package com.javainuse.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductServciceAspect {

    @Before("@annotation(com.javainuse.anonation.ServiceAnnonation)")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before method:" + joinPoint.getSignature());
    }

    @After("@annotation(com.javainuse.anonation.ServiceAnnonation)")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After method:" + joinPoint.getSignature());
    }

    @Around("@annotation(com.javainuse.anonation.ServiceAnnonation)")
    public Object ExecutionTimeInfo(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        final Object proceed = joinPoint.proceed();
        final long executionTime = System.currentTimeMillis() - start;
        String logs= String.format("\n---- Performance aspect ----\n" +
                        "method: %s \n" +
                        "execution time:  %s [ms]\n" +
                        "------------------------\n",
                joinPoint.getSignature().getName(), executionTime);
        System.out.println(logs);
        return proceed;
    }
}
