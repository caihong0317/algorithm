package com.caihong.mutilthread.chapter1;

public class MyDaemon extends Thread {
    private int i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println("i=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
