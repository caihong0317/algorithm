package com.caihong.javathinking.innerclass;

public class WithInner {
    void method(){
        System.out.println("WithInner method");
    }
    class Inner{
        void method(){
            System.out.println("Inner method");
        }
    }
}
