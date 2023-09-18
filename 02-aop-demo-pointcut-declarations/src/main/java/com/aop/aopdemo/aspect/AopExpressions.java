package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect // If there is only @Pointcuts, then @Aspect is optional. Only require if there is advice (@Before / @After)
@Component
@Order(4) // Lower number has higher priority
public class AopExpressions {

//    1 - Create pointcut declaration. (In this case we cut the declaration from @Before from below method below)
//    2 - Replace the declaration for the method below with this method name
    @Pointcut("execution (public * com.aop.aopdemo.dao.*.*())")
    public void forDaoPackage() {
    }

    //    Create pointcut for getter methods
    @Pointcut("execution (public * com.aop.aopdemo.dao.*.get*())")
    public void getter(){}


    //    Create pointcut for setter methods
    @Pointcut("execution (public * com.aop.aopdemo.dao.*.set*())")
    public void setter(){}

    //    Create pointcut : include package -- exclude getter / setter !!!!
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
