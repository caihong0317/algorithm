package com.caihong.java8action.part2.chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1 {
    private static List<Dish> menu = Arrays.asList(
        new Dish("pork", false, 800, Dish.Type.MEAT),
        new Dish("beef", false, 700, Dish.Type.MEAT),
        new Dish("chicken", false, 400, Dish.Type.MEAT),
        new Dish("french fries", true, 530, Dish.Type.OTHER),
        new Dish("rice", true, 350, Dish.Type.OTHER),
        new Dish("season fruit", true, 120, Dish.Type.OTHER),
        new Dish("pizza", true, 550, Dish.Type.OTHER),
        new Dish("prawns", false, 300, Dish.Type.FISH),
        new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {
        test1();
//        test2();
    }

    // 延迟
    public static void test1() {
        Stream<String> limit = menu.stream()
            .filter(d -> {
                System.out.println("filtering " + d.getName());
                return d.getCalories() > 300;
            })
            .map(d -> {
                System.out.println("mapping " + d.getName());
                return d.getName();
            })
            .limit(3);

        List<String> names = limit
            .collect(Collectors.toList());
        System.out.println(names);
    }

    // 无输出
    public static void test2() {
        menu.stream()
            .filter(d -> {
                System.out.println("filtering" + d.getName());
                return d.getCalories() > 300;
            })
            .map(d -> {
                System.out.println("mapping" + d.getName());
                return d.getName();
            })
            .limit(3);
    }
}
