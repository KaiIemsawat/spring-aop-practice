package com.aop.aopdemo.aspect;

import com.aop.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2) // Lower number has higher priority
public class DemoLoginAspect {

//    Add a new Advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution (* com.aop.aopdemo.dao.AccountDAO.findAccounts(..))",
//            This 'com.aop.aopdemo.dao.AccountDAO.findAccounts(..)' need to match with
//            'List<Account> theAccounts = theAccountDAO.findAccounts()' in -> 'AopDemoApplication'
            returning = "result"
            // returning = 'thisValue' need to be match with (JoinPoint theJoinPoint, List<Account> 'thisValue') below
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
//      Print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n--------- >>> Executing @AfterReturning on method : " + method + " <<< ---------");

//      Print out the results of the method call
        System.out.println("\n--------- >>> Result is  : " + result + " <<< ---------");

    }


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
    public void beforeAddWithParameter(JoinPoint theJoinPoint) {
        System.out.println("============= >>> Executing @Before advice on add*(Parameter parameter) <<< =============");

        //        display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method : ========= > " + methodSignature);

//        display method arguments

//        get args
        Object[] args = theJoinPoint.getArgs();

//        loop through args
        for (Object eachArg : args) {
            System.out.println(eachArg);

            if (eachArg instanceof Account) {
//                downcast and print Account specific stuff
                Account theAccount = (Account) eachArg;

                System.out.println("Account name : ========== > " + theAccount.getName());
                System.out.println("Account level : ========== > " + theAccount.getLevel());
            }
        }
    }

    /* -- @Pointcut -- */
//    Pointcuts have been moved to AopExpressions


//    access modifier / return type / package / class (any class in this case) / method (any method in this case) / parameter (any parameter in this case)
//    public / * / com.aop.aopdemo.dao/.*/.*/(..))
    @Before("com.aop.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void beforeAddAccountInSpecificPackage() {
        System.out.println("============= >>> Executing @Before advice on anyClass and anyMethod(). In a specific package <<< =============");
    }

    @Before("com.aop.aopdemo.aspect.AopExpressions.forDaoPackage() && !(com.aop.aopdemo.aspect.AopExpressions.getter() || com.aop.aopdemo.aspect.AopExpressions.setter())")
    public void beforeAddAccountInPackageNoGetterSetter() {
        System.out.println("============= >>> Executing @Before advice on anyClass and anyMethod(). In a specific package. No Getter / Setter <<< =============");
    }

//    performApiAnalytics() Has been moved to ApiAnalyticAspect

//    logToCloudAsync() Has been moved to CloudLogAsyncAspect


    /* Once refactored, 'paths need to be added to @Before() or @After */
//    For example -->     @Before("com.aop.aopdemo.aspect.AopExpressions.forDaoPackage() && !(com.aop.aopdemo.aspect.AopExpressions.getter() || com.aop.aopdemo.aspect.AopExpressions.setter())")
}
