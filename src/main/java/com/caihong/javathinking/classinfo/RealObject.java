package com.caihong.javathinking.classinfo;

public class RealObject implements Action {
    @Override
    public void doSomething() {
        System.out.println("RealObject doSomething");
    }

    @Override
    public void doOther(String str) {
        System.out.println("RealObject doOther "+str);
    }
}
