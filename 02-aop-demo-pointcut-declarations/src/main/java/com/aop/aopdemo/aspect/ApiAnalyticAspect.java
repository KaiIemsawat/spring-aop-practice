package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApiAnalyticAspect {

    //    With pointcut, we can use it in multiple locations
    @Before("com.aop.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("============= >>> Performing API analytics <<< =============");
    }


}
