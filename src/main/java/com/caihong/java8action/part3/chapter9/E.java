package com.caihong.java8action.part3.chapter9;

public interface E {
    default void hello() {
        System.out.println("Hello from E");
    }
}
