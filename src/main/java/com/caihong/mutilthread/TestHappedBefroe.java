package com.caihong.mutilthread;

public class TestHappedBefroe {
    volatile static int x;
    static int y;

    public static void main(String[] args) {
        new Thread(() -> {
            y = 10;
            x = 20;
        }, "t1").start();
        new Thread(() -> {
            // x=20 对 t2 可见, 同时 y=10 也对 t2 可见
            System.out.println(y);
            System.out.println(x);
            System.out.println(y);
        }, "t2").start();
    }
}
