package com.caihong.designpattern.mediator;

public class ConcreteColleague extends Colleague {
    private final String name;
    private boolean changed=false;

    public ConcreteColleague(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    @Override
    public void selfMethod() {
        if (changed){
            communicate(this);
        }
    }
}
