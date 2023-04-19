package com.caihong.mutilthread.chapter3;

public class MyThreadLocal {
    public static ThreadLocal<String> local = new ThreadLocal();
    public static ThreadLocal<Integer> local2 = new ThreadLocal();
    public static ThreadLocal<Boolean> local3 = new ThreadLocal();

    public static void main(String[] args) {
        local.set("local");
        local2.set(1);
        local3.set(Boolean.TRUE);
        System.out.println(local.get());
        System.out.println(local2.get());
        System.out.println(local3.get());
    }
}
