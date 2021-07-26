package com.example.annotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class  HLogAspect {

    /**
     * 其中@Pointcut声明了切点（这里的切点是我们自定义的注解类），
     * @Before声明了通知内容，在具体的通知中，我们通过@annotation(logger)拿到了自定义的注解对象，
     * 所以就能够获取我们在使用注解时赋予的值了。
     */


    @Pointcut("@annotation(com.example.annotation.SelfAnnotation)")
    public  void annotationPointCut() {
        System.out.println("------------------");
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        //类名
        String clsName=joinPoint.getSignature().getDeclaringType().getSimpleName();
        //方法名
        String modName= joinPoint.getSignature().getName();
        //参数
        Object[] args = joinPoint.getArgs();
        StringBuffer result = new StringBuffer();
        result.append("["+clsName+"]");
        result.append("["+modName+"]");
        Arrays.stream(args).forEach(arg->{
                result.append("["+arg+"]");
        });
        System.out.println(result.toString());
    }
}
