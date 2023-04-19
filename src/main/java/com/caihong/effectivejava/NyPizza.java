package com.caihong.effectivejava;

import java.util.Objects;

public class NyPizza extends Pizza {
    private final Size size;

    public enum Size {SMALL, MEDIUM, LARGE}

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static void main(String[] args) {
        NyPizza nyPizza = new Builder(Size.SMALL)
            .addTopping(Topping.HAM).addTopping(Topping.PEPPER).build();
    }
}
