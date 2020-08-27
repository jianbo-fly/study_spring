package com.study.exception;

public class TransMoneyException extends Throwable {

    public String[] exceptionForTrans(){
        System.out.println("转账错误");
        String[] a={"错误"};
        return a;
    }
}
