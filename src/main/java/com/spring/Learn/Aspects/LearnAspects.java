package com.spring.Learn.Aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

public abstract class LearnAspects {

    @Pointcut("within(com.spring.Learn..*)")
    protected void inController() {}



}
