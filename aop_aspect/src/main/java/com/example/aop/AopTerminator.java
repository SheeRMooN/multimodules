package com.example.aop;

import com.example.Terminator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopTerminator {

    @After("execution(* com.example.Terminator.messageAfter(..))")
    public void testAop(JoinPoint joinPoint){
        System.out.println("method = " + joinPoint.getSignature().getName());

    }
    @Around("execution(* com.example.Terminator.messageAround(..))")
    public void aroundTer(ProceedingJoinPoint joinPoint) throws Throwable {
        Terminator tt = (Terminator) joinPoint.getThis();
        tt.setKills(1);
        System.out.println("method = " + joinPoint.getSignature().getName());

        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        };
    }
    @Before("execution(* com.example.Terminator.messageBefore(..))")
    public void beforeTer(JoinPoint joinPoint){
        Terminator tt = (Terminator) joinPoint.getThis();
        tt.setName("T542");
        tt.setModel("ARG-24");
        tt.setKills(10);
        System.out.println("method = " + joinPoint.getSignature().getName());
    }
}
