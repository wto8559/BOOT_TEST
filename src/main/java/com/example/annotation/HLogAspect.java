package com.example.annotation;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
@SuppressWarnings({"unused"})
public class HLogAspect {

    public HLogAspect() {
        System.out.println("===>HLogAspect start");
    }

    @Pointcut("@annotation(com.example.annotation.WtSelfAnnotation)")
    public void cut() {
        System.out.println("3");
    }


    @Around("cut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("1");
        try {
            joinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("4");

    }

    @Before("cut()")
    public void before() {
        System.out.println("2");
    }

    @After("cut()")
    public void after() {
        System.out.println("5");
    }


}
