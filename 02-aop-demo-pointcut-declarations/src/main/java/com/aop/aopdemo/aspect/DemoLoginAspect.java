package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

//    This specific made the method works only with the mentioned method in the package
    @Before("execution (public void com.aop.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdviceWithSpecificPackage() {
        System.out.println("============= >>> Executing @Before advice on addAccount() with specific package <<< =============");
    }

//    Using 'wildcard' makes the selection matching with any class the same part of method name
//    In this case, 'add*()', will count any method that start with 'add'
    @Before("execution (public void add*())")
    public void beforeAddWithWildcard() {
        System.out.println("============= >>> Executing @Before advice on add*() <<< =============");
    }

//    Only fire before methods that return type is 'boolean' AND have method name as 'addAccount()'
//    '*' could be used to refer to any type of return types
    @Before("execution (public boolean addAccount())")
    public void beforeReturnTypeStringAddAccount() {
        System.out.println("============= >>> Executing @Before advice on addAccount() that return boolean <<< =============");
    }

//    This method will fire in this scenario
//    Any return type AND any method name that start with add AND requires parameter type 'Account' AND any other arguments
//    '..' mean any number of arguments (another type of wildcard. Used for arguments)
//    If replace '..' with something like 'String',
//    this method with fire if conditions above meet but only with 'Account' and 'String' types of arguments
    @Before("execution (public * add*(com.aop.aopdemo.Account, ..))")
    public void beforeAddWithParameter() {
        System.out.println("============= >>> Executing @Before advice on add*(Parameter parameter) <<< =============");
    }


//    1 - Create pointcut declaration. (In this case we cut the declaration from @Before from below method below)
//    2 - Replace the declaration for the method below with this method name
    @Pointcut("execution (public * com.aop.aopdemo.dao.*.*())")
    private void forDaoPackage() {
    }

//    Create pointcut for getter methods
    @Pointcut("execution (public * com.aop.aopdemo.dao.*.get*())")
    private void getter(){}


//    Create pointcut for setter methods
    @Pointcut("execution (public * com.aop.aopdemo.dao.*.set*())")
    private void setter(){}

//    Create pointcut : include package -- exclude getter / setter !!!!
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

//    access modifier / return type / package / class (any class in this case) / method (any method in this case) / parameter (any parameter in this case)
//    public / * / com.aop.aopdemo.dao/.*/.*/(..))
    @Before("forDaoPackage()")
    public void beforeAddAccountInSpecificPackage() {
        System.out.println("============= >>> Executing @Before advice on anyClass and anyMethod(). In a specific package <<< =============");
    }

    @Before("forDaoPackage() && !(getter() || setter())")
    public void beforeAddAccountInPackageNoGetterSetter() {
        System.out.println("============= >>> Executing @Before advice on anyClass and anyMethod(). In a specific package. No Getter / Setter <<< =============");
    }

//    With pointcut, we can use it in multiple locations
    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("============= >>> Performing API analytics <<< =============");
    }





}
