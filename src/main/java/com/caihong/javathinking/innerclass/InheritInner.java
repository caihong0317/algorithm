package com.caihong.javathinking.innerclass;

public class InheritInner extends WithInner.Inner  {
    InheritInner(WithInner withInner){
        withInner.super();
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        InheritInner inheritInner = new InheritInner(withInner);
        inheritInner.method(); // Inner method
    }
}
