package com.caihong.effectivejava;

public class MyStack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;

    public MyStack() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    protected MyStack clone() {
        try {
//            return (MyStack) super.clone(); // 浅拷贝
            MyStack clone = (MyStack) super.clone();
            clone.elements = elements.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
