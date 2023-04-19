package com.caihong.mutilthread.chapter1;

public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread taskThread = new Thread(task);
        taskThread.start();
        Thread.currentThread().sleep(3000);
        taskThread.interrupt();
        System.out.println(task.getCount());
        System.out.println(task.getCount());
    }

    static class Task implements Runnable {
        int count = 1;

        @Override
        public void run() {
            while (Thread.interrupted()) {
                count++;
            }
//            System.out.println("中断了");
        }

        public int getCount() {
            return count;
        }
    }
}
