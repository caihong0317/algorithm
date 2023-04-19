package com.caihong.javathinking.classinfo;

public class ProxyObjectTest {
    public static void consume(Action action,String str){
        action.doSomething();
        action.doOther(str);
        System.out.println("------");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consume(realObject,"sleep");
        consume(new ProxyObject(realObject),"sleep");
        consume(new ProxyObject(new ProxyObject(realObject)),"sleep");
    }
}
