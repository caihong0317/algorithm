package com.caihong.mutilthread.chapter2;

import org.junit.Test;

public class MyThreadTest {

    public static void main(String[] args) {
        try {
            Account account = new Account();
            AccountThread accountThread = new AccountThread(account);
            accountThread.start();
            Thread.sleep(1000);
            System.out.println("getValue " + Thread.currentThread().getName() + account.getValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 用此方法测试有问题，主方法结束时会终止accountThread线程
    @Test
    public void testAccount() {
        try {
            Account account = new Account();
            AccountThread accountThread = new AccountThread(account);
            accountThread.start();
            Thread.sleep(3000);
            System.out.println(account);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}