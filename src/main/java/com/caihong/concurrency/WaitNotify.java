package com.caihong.concurrency;

public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new WaitThread()).start();
        Thread.currentThread().sleep(500);
        new Thread(new NotifyThread()).start();
    }

    static class WaitThread implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("WaitThread enter");
                while (flag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("WaitThread end");
            }
        }
    }

    static class NotifyThread implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("NotifyThread enter");
                lock.notify();
                flag = false;
                System.out.println("NotifyThread end");
            }

            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock) { // 再次竞争锁
                System.out.println("NotifyThread enter again");
            }
        }
    }
}