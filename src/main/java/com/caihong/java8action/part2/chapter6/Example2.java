package com.caihong.java8action.part2.chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class Example2 {
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
/*
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
            .filter(i -> i % 2 == 0)
            .distinct()
            .forEach(System.out::println);
*/
/*
        List<Integer> dishNameLengths = menu.stream()
            .map(Dish::getName)
            .map(String::length)
            .collect(toList());
        System.out.println(dishNameLengths);
*/

/*
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");
        List<String[]> collect = words.stream()
            .map(word -> word.split(""))
            .distinct()
            .collect(toList());
        System.out.println(collect); // [[Ljava.lang.String;@35f983a6, [Ljava.lang.String;@7f690630]

        List<Stream<String>> collect2 = words.stream()
            .map(word -> word.split(""))
            .map(Arrays::stream)
            .distinct()
            .collect(toList());
        System.out.println(collect2);

        List<String> collect3 = words.stream()
            .map(word -> word.split(""))
            .flatMap(Arrays::stream)
            .distinct()
            .collect(toList());
        System.out.println(collect3); // [H, e, l, o, W, r, d]
*/

/*
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
            .map(n -> n * n)
            .collect(toList());
        System.out.println(squares); // [1, 4, 9, 16, 25]

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> collect = numbers1.stream()
            .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
            .collect(toList());
        collect.forEach(item -> System.out.print(Arrays.toString(item))); // [1, 3][1, 4][2, 3][2, 4][3, 3][3, 4]
        // 或者链式编程
        numbers1.stream()
            .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
            .collect(toList())
            .forEach(item -> System.out.print(Arrays.toString(item)));
*/

/*
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        Optional<Dish> dish =
            menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        dish.ifPresent(System.out::println);
*/

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = numbers.stream().reduce(0, Math::addExact);
        Integer sum1 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum); // 15

        Optional<Integer> sum2 = numbers.stream().reduce(Integer::sum);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
    }

    public static void test1() {
        List<String> names =
            menu.stream()
                .filter(d -> {
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(toList());
        System.out.println(names);
    }
}
