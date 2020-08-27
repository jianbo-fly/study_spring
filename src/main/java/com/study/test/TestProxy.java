package com.study.test;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 基于接口的动态代理
 */
@Component(value = "testProxy")
public class TestProxy{
    Object target;
    public TestProxy(Object target){
        this.target=target;
    }
    /*@Autowired
    @Qualifier("accountService1")
    private AccountService accountService;*/

/*    public void test(){
        Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        Object returnValue=null;
                        //这是个前置通知
                        System.out.println("这是一个前置通知！");
                        if (method.getName().equals("descMoney")){
                            returnValue=   method.invoke(accountService,objects);
                        }
                        return returnValue;
                    }
                });
    }*/

    public Object test2(){

          Object o=  java.lang.reflect.Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new java.lang.reflect.InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Object returnValue = null;
                    //这是个前置通知
                    System.out.println("这是一个前置通知！");
                 //   System.out.println(proxy);
                   // System.out.println(proxy);
                    if (method.getName().equals("descMoney")) {
                        returnValue = method.invoke(target, args);
                    }
                    return returnValue;
                }

            });
          return o;

    }

}
