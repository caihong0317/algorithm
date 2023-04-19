package com.caihong.designpattern.decorator;

public class Client {
    public static void main(String[] args) {
/*
         // 透明装饰
        AbstractComponent component_o,component_d;
        component_o = new ComponentA();
        component_d=new DecoratorA(component_o);
        component_d.operate();*/

        // 半透明装饰
        AbstractComponent component_o= new ComponentA();
        DecoratorA component_d=new DecoratorA(component_o);
        component_d.operate();
        component_d.addBehaviorOne();
        component_d.addBehaviorTwo();
        // 无意义
        DecoratorB decoratorB =new DecoratorB(component_d);
    }
}
