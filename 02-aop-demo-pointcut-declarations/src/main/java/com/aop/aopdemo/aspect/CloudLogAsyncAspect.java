package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // Lower number has higher priority
public class CloudLogAsyncAspect {

    @Before("com.aop.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("============= >>> Logging to Cloud in async fashion <<< =============");
    }

}
