package com.caihong.designpattern.decorator;

public class DecoratorB extends Decorator {
    public DecoratorB(AbstractComponent component) {
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
