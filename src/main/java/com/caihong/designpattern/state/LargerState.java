package com.caihong.designpattern.state;

public class LargerState extends ScreenState {
    @Override
    public void display() {
        System.out.println("two size");
    }
}
