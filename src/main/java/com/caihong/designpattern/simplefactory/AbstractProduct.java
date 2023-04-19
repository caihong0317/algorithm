package com.caihong.designpattern.simplefactory;

// 抽象层
public abstract class AbstractProduct {
    private int id;
    private String name;

    //common method
    protected void common(){}

    // diff
    public abstract void diff();
}
