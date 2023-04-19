package com.caihong.java8action.part3.chapter9;

public class F implements A, E {
    public static void main(String[] args) {
        new F().hello();
    }

    //不重写报错
    @Override
    public void hello() {
        E.super.hello();
    }

/*
    //不重写报错
    @Override
    public void hello() {
        System.out.println("Hello from F");
    }
*/
}
