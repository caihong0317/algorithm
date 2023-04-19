package com.caihong.designpattern.singleton;

/*
// 线程不安全的
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if (instance == null) {
            instance=new LazySingleton();
        }
        return instance;
    }
}
*/

public class LazySingleton {
    private volatile static LazySingleton instance = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized(LazySingleton.class) {
                if (instance==null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
