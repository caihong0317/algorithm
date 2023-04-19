package com.caihong.java8action.chapter1;

public class WeightApple implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()>150;
    }
}
