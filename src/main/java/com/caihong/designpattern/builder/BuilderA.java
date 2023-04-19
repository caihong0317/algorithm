package com.caihong.designpattern.builder;

public class BuilderA extends AbstractBuilder {
    @Override
    void buildPartA() {
        product.setPartA("A");
    }

    @Override
    void buildPartB() {
        product.setPartB("B");
    }

    @Override
    void buildPartC() {
        product.setPartC("C");
    }

    @Override
    void buildPartD() {
        product.setPartC("D");
    }

    @Override
    protected boolean hasPartD() {
        return false;
    }
}
