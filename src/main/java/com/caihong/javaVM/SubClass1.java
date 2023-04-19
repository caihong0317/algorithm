package com.caihong.javaVM;

public class SubClass1 {
    static {
        System.out.println("SubClass init");
    }

    // 主类肯定会被初始化
    public static void main(String[] args) {
        System.out.println(SuperClass.value); // SuperClass不会被初始化
    }
}
