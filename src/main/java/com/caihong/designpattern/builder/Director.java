package com.caihong.designpattern.builder;

public class Director {
    /*
        private AbstractBuilder builder;

        public Director(AbstractBuilder builder) {
            this.builder = builder;
        }
    */
    public Product construct(AbstractBuilder builder) {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        if (builder.hasPartD()) {
            builder.buildPartD();
        }
        return builder.getProduct();
    }
}
