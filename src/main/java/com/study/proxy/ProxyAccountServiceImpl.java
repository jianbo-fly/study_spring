package com.study.proxy;

import com.study.dao.AccountDao;
import com.study.entertity.Account;
import com.study.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("accountService2")
public class ProxyAccountServiceImpl extends AccountServiceImpl  {

    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> getAllAccount() {
        System.out.println("这是个代理模式！");
        return accountDao.getAllAccount();
    }
}
