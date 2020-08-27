package com.study.javaProxy.method2;

import com.study.service.AccountService;
import com.study.service.impl.AccountServiceImpl;

public class test {
    public static void main(String[] args) {
        AccountService accountService=new AccountServiceImpl();
       AccountService service= (AccountService) new AccoutProxy(accountService).getProxy();
       service.descMoney("aaa",11);
    }
}
