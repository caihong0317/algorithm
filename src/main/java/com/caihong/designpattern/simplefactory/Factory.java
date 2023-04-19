package com.caihong.designpattern.simplefactory;

public class Factory {
    public static AbstractProduct getProduct(String name) {
        AbstractProduct product = null;
        if ("productA".equalsIgnoreCase(name)) {
            product = new ProductA();
        }
        if ("productB".equalsIgnoreCase(name)) {
            product = new ProductB();
        }
        return product;
    }
}
