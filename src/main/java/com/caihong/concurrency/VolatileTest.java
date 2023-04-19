package com.caihong.concurrency;

public class VolatileTest {
    public static volatile int race = 0;

    public static void main(String[] args) {
        System.out.println("start");
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        race++;
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
