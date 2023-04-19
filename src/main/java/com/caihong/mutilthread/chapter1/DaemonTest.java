package com.caihong.mutilthread.chapter1;

public class DaemonTest {
    public static void main(String[] args) {
        MyDaemon myDaemon = new MyDaemon();
        myDaemon.setDaemon(true);
        myDaemon.start();
        try {
            Thread.sleep(5000);
            System.out.println("myDaemon自动结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
