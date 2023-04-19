package com.caihong.designpattern.state;

public class NormalState extends ScreenState {
    @Override
    public void display() {
        System.out.println("normal size");
    }
}
