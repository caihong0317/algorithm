package com.caihong.javathinking.innerclass;

public class Z extends D {
    public E makeE(){
        return new EImpl();
    }
    class EImpl extends E{
        @Override
        void action() {
            System.out.println("EImpl action()");
        }
    }
}
