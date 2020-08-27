package com.study.service;

public interface AccountService {

  //List<Account> getAllAccount();

  void transMoney(String giveName, String recciveName, double money);

  int descMoney(String giveName, double money);
}
