package com.caihong.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected final List<Observer> observerList = new ArrayList<>(10);

    public abstract void talk();

    public void attack(Observer observer) {
        observerList.add(observer);
    }

    public void detach(Observer observer) {
        observerList.remove(observer);
    }
}
