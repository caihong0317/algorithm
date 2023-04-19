package com.caihong.java8action.chapter2;

public class Example1 {
    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        Example1 m = new Example1();
        m.doIt(); // 5
    }
}
