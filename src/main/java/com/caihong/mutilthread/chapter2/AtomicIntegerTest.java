package com.caihong.mutilthread.chapter2;

public class AtomicIntegerTest {
    public static void main(String[] args) {
        MyAtomicInteger myAtomicInteger = new MyAtomicInteger();
        for (int i = 0; i < 5; i++) {
            new Thread(myAtomicInteger).start();  // 5000
        }
    }
}