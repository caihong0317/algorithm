package com.caihong.effectivejava;

public class NutritionFacts {
    private final int servingSize;
    private final int serving;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int drate;

    private NutritionFacts(Builder builder) {
        this.servingSize = builder.servingSize;
        this.serving = builder.serving;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.drate = builder.drate;
    }

    public NutritionFacts(int servingSize, int serving) {
        this(servingSize, serving, 0);
    }

    public NutritionFacts(int servingSize, int serving, int calories) {
        this(servingSize, serving, calories, 0, 0, 0);
    }
    //    ...

    public NutritionFacts(int servingSize, int serving, int calories, int fat, int sodium, int drate) {
        this.servingSize = servingSize;
        this.serving = serving;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.drate = drate;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
            "servingSize=" + servingSize +
            ", serving=" + serving +
            ", calories=" + calories +
            ", fat=" + fat +
            ", sodium=" + sodium +
            ", drate=" + drate +
            '}';
    }

    public static class Builder {
        // nessasory
        private final int servingSize;
        private final int serving;
        // optional
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int drate = 0;

        public Builder(int servingSize, int serving) {
            this.servingSize = servingSize;
            this.serving = serving;
        }

        public Builder calories(int value) {
            this.calories = value;
            return this;
        }

        public Builder fat(int value) {
            this.fat = value;
            return this;
        }

        public Builder sodium(int value) {
            this.sodium = value;
            return this;
        }

        public Builder drate(int value) {
            this.drate = value;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    public static void main(String[] args) {
        NutritionFacts build = new Builder(240, 8).calories(100).sodium(35).drate(27).build();
        System.out.println(build);
    }
}