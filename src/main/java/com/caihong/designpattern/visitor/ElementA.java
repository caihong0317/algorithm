package com.caihong.designpattern.visitor;

public class ElementA implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }
}
