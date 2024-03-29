package com.spring.Learn.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
public class LearnAspectsImpl extends LearnAspects{

    @Around("inController()")
    public void inControllerExecute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("I am in AOP");
        pjp.proceed();
    }
}
