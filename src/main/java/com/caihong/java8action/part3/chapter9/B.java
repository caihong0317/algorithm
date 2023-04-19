package com.caihong.java8action.part3.chapter9;

public interface B extends A{
    default void hello() {
        System.out.println("Hello from B");
    }
}
