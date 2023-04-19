package com.caihong.designpattern.decorator;

public class Decorator extends AbstractComponent{
    private AbstractComponent component;

    public Decorator(AbstractComponent component) {
        this.component = component;
    }

    @Override
    public void operate() {
        component.operate();
    }
}
