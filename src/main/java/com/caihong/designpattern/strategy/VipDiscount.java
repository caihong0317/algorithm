package com.caihong.designpattern.strategy;

public class VipDiscount extends Discount {

    @Override
    public double doDiscount(double price) {
        return price * 0.85;
    }
}
