package com.study.javaProxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class JavaProxy<T> {

    public Object methodHand(T in) {
        final T t = in;
        T s = (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //可以做一个前置通知
                if (method.getName().equals("descMoney")){
                    System.out.println("这是前置通知");
                }
                return method.invoke(t, objects);
        }

        });
        return s;

    }
}
