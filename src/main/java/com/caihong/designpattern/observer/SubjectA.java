package com.caihong.designpattern.observer;

public class SubjectA extends Subject {
    @Override
    public void talk() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
