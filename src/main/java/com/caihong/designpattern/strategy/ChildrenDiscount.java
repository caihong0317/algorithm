package com.caihong.designpattern.strategy;

public class ChildrenDiscount extends Discount {

    @Override
    public double doDiscount(double price) {
        return price * 0.5;
    }
}
