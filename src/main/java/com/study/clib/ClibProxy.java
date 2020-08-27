package com.study.clib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 基于类的动态代理
 */
@Component
public class ClibProxy {
    Object target;

    public ClibProxy(Object target) {
        this.target = target;
    }

    public Object testClib() {
        Object o = Enhancer.create(target.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue;
                //这是个前置通知
                System.out.println("这是一个前置通知！");
                returnValue = method.invoke(target, objects);
                return returnValue;
            }
        });
        return o;
    }

}
