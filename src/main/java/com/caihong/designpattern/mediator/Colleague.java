package com.caihong.designpattern.mediator;

public abstract class Colleague {
    protected final Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void selfMethod();

    public void communicate(Colleague colleague){
        mediator.operate(colleague);
    }

}
