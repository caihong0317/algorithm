package com.caihong.designpattern.factorymethod;

import com.caihong.designpattern.simplefactory.AbstractProduct;
import com.caihong.designpattern.simplefactory.ProductA;
import com.caihong.designpattern.simplefactory.ProductB;

public class FactoryB implements Factory {
    @Override
    public AbstractProduct factoryMethod() {
        return new ProductB();
    }
}
