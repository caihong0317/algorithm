package com.caihong.designpattern.singleton;

public class Singleton {
    private Singleton() {
    }

    public static Singleton getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        static Singleton instance = new Singleton();
    }

    // other business method

}
