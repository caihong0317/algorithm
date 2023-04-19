package com.caihong.mutilthread.chapter3;

public class ListThreadA extends Thread {
    private Object lock;

    public ListThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println(Thread.currentThread().getName() + " begin wait");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " wait end");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
