package com.caihong.concurrency;

public class DeadLockDemo {
    private static final Object a = new Object();
    private static final Object b = new Object();

    public static void main(String[] args) {
        deadLock();
    }

    public static void deadLock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    System.out.println("a");
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b) {
                        System.out.println(1);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    System.out.println("b");
                    synchronized (a) {
                        System.out.println(2);
                    }
                }
            }
        }).start();
    }
}
