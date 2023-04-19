package com.caihong.designpattern.flyweight;

public class FlyweightA extends AbstractFlyweight {

    private String intrinsicState;

    public FlyweightA(){};

    public FlyweightA(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    public void setIntrinsicState(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operate(String extrinsicState) {

    }
}
