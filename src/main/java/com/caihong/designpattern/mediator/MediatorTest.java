package com.caihong.designpattern.mediator;

public class MediatorTest {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ConcreteColleague colleagueA = new ConcreteColleague(mediator, "A");
        Colleague colleagueB = new ConcreteColleague(mediator, "B");
        mediator.register(colleagueA);
        mediator.register(colleagueB);
        colleagueA.setChanged(true);
        colleagueA.selfMethod();
    }
}
