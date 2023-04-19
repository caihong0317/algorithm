package com.caihong.mutilthread.chapter3;

public class MyListTest {
    public static void main(String[] args) {
        Object lock = new Object();
        ListThreadA listThreadA = new ListThreadA(lock);
        ListThreadB listThreadB = new ListThreadB(lock);
        listThreadA.setName("ThreadA");
        listThreadB.setName("ThreadB");
        try {
            listThreadA.start();
            Thread.sleep(50);
            listThreadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
