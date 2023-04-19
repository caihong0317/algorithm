package com.caihong.designpattern.decorator;

public class DecoratorA extends Decorator {
    public DecoratorA(AbstractComponent component) {
        super(component);
    }

    @Override
    public void operate() {
        addBehaviorOne();
        super.operate();
        addBehaviorTwo();
    }

    public void addBehaviorTwo() {
    }

    public void addBehaviorOne() {

    }
}
