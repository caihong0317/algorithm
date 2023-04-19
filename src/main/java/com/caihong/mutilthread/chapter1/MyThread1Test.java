package com.caihong.mutilthread.chapter1;

public class MyThread1Test {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread a = new Thread(myThread1, "A");
        Thread b = new Thread(myThread1, "B");
        Thread c = new Thread(myThread1, "C");
        Thread d = new Thread(myThread1, "D");
        Thread e = new Thread(myThread1, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
