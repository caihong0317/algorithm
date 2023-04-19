package com.caihong.javathinking.myinterface;

public class Apply {
    public static void process(Processor processor, Object input){
        System.out.println(processor.name());
        System.out.println(processor.process(input));
    }
}
