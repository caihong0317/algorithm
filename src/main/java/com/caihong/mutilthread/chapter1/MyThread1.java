package com.caihong.mutilthread.chapter1;

public class MyThread1 extends Thread {
    private int count = 5;

    public MyThread1(){};
    public MyThread1(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
//        withWhile();
        noWhile();
    }

    synchronized private void withWhile() {
        while (count > 0) {
            count--;
            System.out.println("由" + Thread.currentThread().getName() + "计算，count=" + count);
        }
    }

    private  void noWhile() {
        count--;
        System.out.println("由" + Thread.currentThread().getName() + "计算，count=" + count);
    }
}
