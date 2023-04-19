package com.caihong.designpattern.memento;

class Memento {
    private final String state;

    public Memento(Originator originator) {
        state = originator.getState();
    }

    public String getState() {
        return state;
    }
}
