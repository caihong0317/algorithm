package com.caihong.designpattern.factorymethod;

import com.caihong.designpattern.simplefactory.AbstractProduct;
import com.caihong.designpattern.simplefactory.ProductA;

public class FactoryA implements Factory {
    @Override
    public AbstractProduct factoryMethod() {
        return new ProductA();
    }
}
