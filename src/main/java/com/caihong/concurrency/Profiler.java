package com.caihong.concurrency;

public class Profiler {
    private static ThreadLocal<Long> time = new ThreadLocal<>();

    public static void begin() {
        time.set(System.currentTimeMillis());
    }

    public static long end() {
        return System.currentTimeMillis() - time.get();
    }

    public static void main(String[] args) throws InterruptedException {
        begin();
        Thread.sleep(500);
        System.out.println("cost: " + end());
    }
}
