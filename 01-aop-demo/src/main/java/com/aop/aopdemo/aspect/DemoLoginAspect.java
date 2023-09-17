package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoginAspect {

//    This is where we add all the related advices for logging

    /* -- @Before -- */
//    Start with @Before advice
//    pointcut expression
//    Run this code BEFORE target object method: "public void addAccount()"
//    IF there are more than one method that share the same name (in this case addAccount()), both will have @Before fired before
    @Before("execution (public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("============= >>> Executing @Before advice on addAccount() <<< =============");
    }

    @Before("execution (public void com.aop.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdviceWithSpecificPackage() {
        System.out.println("============= >>> Executing @Before advice on addAccount() with specific package <<< =============");
    }

}
