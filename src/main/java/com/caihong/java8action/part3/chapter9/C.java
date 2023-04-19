package com.caihong.java8action.part3.chapter9;

public class C extends D implements A, B {
    public static void main(String[] args) {
        new C().hello();
    }

    public void hello(){
        System.out.println("Hello from C");
    }
}
