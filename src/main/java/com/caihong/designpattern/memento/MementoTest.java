package com.caihong.designpattern.memento;

public class MementoTest {
    public static void main(String[] args) {
        Originator originator = new Originator("state1");
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setState("state2");
        originator.restoreMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }
}
