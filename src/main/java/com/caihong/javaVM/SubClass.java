package com.caihong.javaVM;

public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }

    // 主类肯定会被初始化
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
