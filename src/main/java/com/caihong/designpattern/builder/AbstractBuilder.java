package com.caihong.designpattern.builder;

public abstract class AbstractBuilder {
    protected Product product;

    abstract void buildPartA();

    abstract void buildPartB();

    abstract void buildPartC();

    abstract void buildPartD();

    protected boolean hasPartD(){
        return true;
    }

    protected Product getProduct() {
        return product;
    }
}
