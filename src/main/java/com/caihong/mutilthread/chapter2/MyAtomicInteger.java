package com.caihong.mutilthread.chapter2;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger extends Thread {
    private AtomicInteger count = new AtomicInteger(0);


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(count.incrementAndGet());
        }
    }
}
