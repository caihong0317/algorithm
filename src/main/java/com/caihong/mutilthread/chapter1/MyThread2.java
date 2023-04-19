package com.caihong.mutilthread.chapter1;

public class MyThread2 extends Thread {

    public MyThread2(){}
    public MyThread2(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("MyThread2");
        System.out.println(Thread.currentThread().getName());
    }
}
