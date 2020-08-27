package com.study.clib;

import com.study.service.impl.NewAccountServiceImpl;

public class Test {
    public static void main(String[] args) {
        ClibProxy clibProxy=new ClibProxy(new NewAccountServiceImpl());
        NewAccountServiceImpl service=(NewAccountServiceImpl) clibProxy.testClib();
        service.descMoneyNew("aaa",300);
    }
}
