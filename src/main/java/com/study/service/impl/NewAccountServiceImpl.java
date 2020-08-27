package com.study.service.impl;

import org.springframework.stereotype.Component;

@Component(value = "newAccount")
public class NewAccountServiceImpl {
    public int descMoneyNew(String giveName,double money){
        System.out.println("这是实现类desc");
       // accountDao.addMoney(giveName,money);
        return 1;
    }
}
