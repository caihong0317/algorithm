package com.caihong.designpattern.visitor;

public abstract class Visitor {
    public abstract void visitElementA(Element element);

    public abstract void visitElementB(Element element);

    protected void visitElementC(Element element) {

    }
}
