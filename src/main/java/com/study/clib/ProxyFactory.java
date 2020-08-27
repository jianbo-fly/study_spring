package com.study.clib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类代理对象
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] arg2, MethodProxy proxy) throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("开始事务...");
        Object returnValue = method.invoke(target, arg2);
        System.out.println("提交事务...");
        return returnValue;
    }
}

