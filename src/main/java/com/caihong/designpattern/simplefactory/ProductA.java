package com.caihong.designpattern.simplefactory;

public class ProductA extends AbstractProduct {
    @Override
    public void diff() {
        System.out.println("生产了productA");
    }

}
