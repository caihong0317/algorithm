package com.caihong.designpattern.visitor;

public interface Element {
    void accept(Visitor visitor);
}
