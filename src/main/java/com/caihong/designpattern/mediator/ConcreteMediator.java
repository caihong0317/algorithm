package com.caihong.designpattern.mediator;

public class ConcreteMediator extends Mediator {

    @Override
    public void operate(Colleague source) {
        for (Colleague colleague : group) {
            if (colleague != source) { // 不和自己对话
                System.out.println("received");
            }
        }
    }
}
