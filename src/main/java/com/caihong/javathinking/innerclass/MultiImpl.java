package com.caihong.javathinking.innerclass;

public class MultiImpl {
    public static void main(String[] args) {
        Z z = new Z();
        z.action();
        z.makeE().action();
    }
}
