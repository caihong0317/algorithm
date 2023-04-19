package com.caihong.designpattern.mediator;

import java.util.ArrayList;
import java.util.List;

public abstract class Mediator {
    protected List<Colleague> group=new ArrayList<Colleague>();

    public void register(Colleague colleague){
        group.add(colleague);
    }

    public abstract void operate(Colleague colleague);
}
