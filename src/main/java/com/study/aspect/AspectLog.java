package com.study.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectLog {

    @Pointcut("execution(* com.study.service.impl.*.*(..))")
    private void pt1(){}


/*    @Before("pt1()")
    public void before(){
        System.out.println("这是一个前置通知！");
    }
    @AfterReturning("pt1()")
    public void afterReturning(){
        System.out.println("这是一个后置通知");
    }
    @After("pt1()")
    public void after(){
        System.out.println("这是一个最终通知！");
    }
    @AfterThrowing("pt1()")
    public void throwMehtod(){
        System.out.println("这是一个异常通知！");
    }*/

/*    @Around(value = "pt1()")
    public Object getLog(ProceedingJoinPoint joinPoint) {
        Object value = null;
        try {
            Object[] oo = joinPoint.getArgs();
            System.out.println("这是前置通知");
            value = joinPoint.proceed(oo);
            System.out.println("这是一个ruturn后置通知");
            return value;
        } catch (Throwable e) {
            System.out.println("这是一个异常通知");
            throw new RuntimeException(e);
        } finally {
            System.out.println("这是一个最终通知");
        }
    }*/

}
