package com.study.service.impl;

import com.study.dao.AccountDao;
import com.study.entertity.Account;
import com.study.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("accountService1")
public class AccountServiceImpl  implements AccountService {
    @Autowired
    private AccountDao accountDao;
    public List<Account> getAllAccount() {
        return accountDao.getAllAccount();
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor=ArithmeticException.class)
    public void transMoney(String giveName, String recciveName, double money) {
        accountDao.descMoney(giveName,money);
     //  int a=1/0;
        accountDao.addMoney(recciveName,money);
    }
    public int descMoney(String giveName,double money){
        System.out.println("这是实现类desc");
       // accountDao.descMoney(giveName,money);
        return 1;
    }

}
