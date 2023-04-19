package com.caihong.javathinking.classinfo;

public class ProxyObject implements Action {
    private Action action;

    public ProxyObject(Action action) {
        this.action = action;
    }

    @Override
    public void doSomething() {
        System.out.println("ProxyObject doSomething");
        action.doSomething();
    }

    @Override
    public void doOther(String str) {
        System.out.println("ProxyObject doOther "+str);
        action.doOther(str);
    }
}
