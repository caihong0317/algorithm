package com.caihong.java8action.part2.chapter6;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Example3 {

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

    static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario", "Milan");
    static Trader alan = new Trader("Alan", "Cambridge");
    static Trader brian = new Trader("Brian", "Cambridge");

    static List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {

/*
        List<Transaction> tr2011 =
            transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        Set<String> cities =
            transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());

        transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::max).ifPresent(System.out::println);
*/

        //求min
        transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::min).ifPresent(System.out::println); // 300
        transactions.stream()
            .reduce((a, b) -> a.getValue() < b.getValue() ? a : b).ifPresent(System.out::println);
        transactions.stream()
            .reduce(BinaryOperator.minBy(comparing(Transaction::getValue))).ifPresent(System.out::println);
        transactions.stream()
            .min(comparing(Transaction::getValue)).ifPresent(System.out::println);

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed();
        int sum = intStream.sum();
        int max = intStream.max().orElse(0);

        IntStream evenNumbers = IntStream.rangeClosed(2, 100) // 闭区间[2, 100]
            .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count()); //50

        IntStream evenNumbers1 = IntStream.range(2, 100) // 闭区间[2, 100)
            .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers1.count()); //49

        Stream<int[]> pythagoreanTriples =
            IntStream.rangeClosed(3, 10).boxed()
                .flatMap(a ->
                    IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                        .mapToObj(b ->
                            new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                );

        //更好
        Stream<double[]> pythagoreanTriples2 =
            IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                    IntStream.rangeClosed(a, 100)
                        .mapToObj(
                            b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                        .filter(t -> t[2] % 1 == 0));

        pythagoreanTriples.limit(5).forEach(t-> System.out.println(Arrays.toString(t)));

    }
}
