package com.spring.Learn.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LearnAspectsImpl extends LearnAspects{

    @After("inController()")
    public void inControllerExecute() throws Throwable {
        System.out.println("I am in AOP");
    }
}
