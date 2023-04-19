package com.caihong.mutilthread.chapter2;

public class MyVolatileTest {
    public static void main(String[] args) {
        MyVolatile[] array = new MyVolatile[10];
        for (int i = 0; i < 10; i++) {
            array[i] = new MyVolatile();
        }
/*
        try {
            for (int i = 0; i < 10; i++) {
                array[i].start();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/

        for (int i = 0; i < 10; i++) {
            array[i].start();
        }

    }
}
