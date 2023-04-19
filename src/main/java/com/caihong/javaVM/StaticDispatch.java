package com.caihong.javaVM;

public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    void sayHello(Human guy) {
        System.out.println("Human hello");
    }

/*
    void sayHello(Man guy) {
        System.out.println("Man hello");
    }
*/

    void sayHello(Woman guy) {
        System.out.println("Woman hello");
    }

    public static void main(String[] args) {
        StaticDispatch dispatch = new StaticDispatch();
        Human man = new Man();
        Human woman = new Woman();
        dispatch.sayHello(man);
        dispatch.sayHello(woman);
        dispatch.sayHello((Man) man);
        dispatch.sayHello((Woman) woman);
    }
}
