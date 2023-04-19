package com.caihong.mutilthread.chapter3;

public class ListThreadB extends Thread {
    private Object lock;

    public ListThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 1; i <= 10; i++) {
                MyList.add();
                System.out.println("第" + i + "个元素");
                if (MyList.size() == 5) {
                    System.out.println(Thread.currentThread().getName() + " send notify");
                    lock.notify();
                }
            }
        }
    }
}