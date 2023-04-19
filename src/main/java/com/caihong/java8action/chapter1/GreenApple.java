package com.caihong.java8action.chapter1;

public class GreenApple implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
