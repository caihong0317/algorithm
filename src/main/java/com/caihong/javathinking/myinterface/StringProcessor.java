package com.caihong.javathinking.myinterface;

public abstract class StringProcessor implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

     public abstract Object process(Object input);
}
