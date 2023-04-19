package com.caihong.designpattern.adapter;

public class Adapter extends Adapteer implements Target {

    @Override
    public void request() {
        specialRequest();
    }
}
