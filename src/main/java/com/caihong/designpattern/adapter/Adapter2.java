package com.caihong.designpattern.adapter;

public class Adapter2 implements Target {
    private Adapteer adapteer;

    public Adapter2(Adapteer adapteer) {
        this.adapteer = adapteer;
    }

    @Override
    public void request() {
        adapteer.specialRequest();
    }
}
