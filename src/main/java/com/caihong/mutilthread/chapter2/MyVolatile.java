package com.caihong.mutilthread.chapter2;

public class MyVolatile extends Thread {
    volatile private static int count;

    synchronized private static void add() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count = " + count);
    }

    @Override
    public void run() {
        add();
    }
}
