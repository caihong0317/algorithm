package com.caihong.mutilthread.chapter2;

public class AccountThread extends Thread {
    private Account account;

    public AccountThread(Account account){
        this.account=account;
    }

    @Override
    public void run() {
        account.init("B","BB");
    }
}