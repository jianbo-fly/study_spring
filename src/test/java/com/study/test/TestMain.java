package com.study.test;

import com.study.config.SpringConfig;
import com.study.proxy.ProxyAccountServiceImpl;
import com.study.service.AccountService;
import com.study.service.impl.AccountServiceImpl;
import com.study.service.impl.NewAccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TestMain {
    @Autowired
    @Qualifier("accountService1")
    private AccountServiceImpl service;

    @Autowired
    @Qualifier("accountService2")
    private ProxyAccountServiceImpl proxyAccountService;
    @Autowired
    private NewAccountServiceImpl newAccountService;


    @Autowired
    public TestProxy testProxy;

    @Test
    public void setTestProxy(){
       // testProxy.target=service;
       // AccountService accountService=new AccountServiceImpl();
        AccountService o=(AccountService) testProxy.test2();
        o.descMoney("aaa",200);
    }

   /* @Autowired
    @Qualifier("clibProxy1")
    private ClibProxy clibProxy;
    @Test
    public void clibProxyTest(){
        ClibProxy clibProxy=new ClibProxy(new NewAccountServiceImpl());
       NewAccountServiceImpl service=(NewAccountServiceImpl) clibProxy.testClib();
        service.descMoneyNew("aaa",300);
    }
*/

 /*   @Autowired
    @Qualifier("accountService3")
    private ProxyAccountServiceImpl2 proxyAccountService2;*/
    @Test
    public void getAllAccountTest(){
     // List<Account> accountList= service.getAllAccount();
     //   System.out.println(accountList.size());
    }

    @Test
    public void  testTransMoney(){
        service.transMoney("aaa","bbb",200);
        System.out.println("成功");
    }

    @Test
    public void  testProxy(){
        proxyAccountService.getAllAccount();
        System.out.println("成功");
    }
    @Test
    public void  testProxy2(){

       // proxyAccountService2.getAllAccount();
        System.out.println("成功");
    }

}
