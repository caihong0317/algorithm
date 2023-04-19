package com.caihong.designpattern.visitor;

public class ElementB implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }
}
