package com.caihong.concurrency;

import static com.caihong.concurrency.DeadLockDemo.deadLock;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Worker(1));
        thread.start();
        thread.start();
        thread.start();
    }

     static class Worker implements Runnable{
        private int i;

         public Worker(int i) {
             this.i = i;
         }

         @Override
         public void run() {
             System.out.println(i);
         }
     }
}
