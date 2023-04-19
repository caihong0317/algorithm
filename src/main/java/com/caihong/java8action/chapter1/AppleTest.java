package com.caihong.java8action.chapter1;

import java.util.ArrayList;
import java.util.List;

// 说明了从类、内部类过渡到lambda的必然
public class AppleTest {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        // 使用实现类
        List<Apple> apples1 = filterApples(inventory, new GreenApple());
        List<Apple> apples2 = filterApples(inventory, new WeightApple());

        // lambda或匿名类
        List<Apple> apples5 = filterApples(inventory, (Apple apple) -> Apple.isGreenApple(apple));

        // 方法引用，无需实现类
        List<Apple> apples3 = filterApples(inventory, Apple::isGreenApple);
        List<Apple> apples4 = filterApples(inventory, Apple::isHeavyApple);
    }

    // 1、写死的方法
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // 2
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    // 3、可拓展
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<? super Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}