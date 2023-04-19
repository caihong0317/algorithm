package com.caihong.java8action.part2.chapter6;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Chapter6 {
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

    public enum CaloricLevel {DIET, NORMAL, FAT}


    public static void main(String[] args) {
/*
        List<Transaction> transactionList = new ArrayList<>();
        List<Transaction> transactions = transactionList.stream().collect(Collectors.toList());

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream()
            .collect(maxBy(dishCaloriesComparator));

        Optional<Dish> mostCalorieDish2 = menu.stream().max(dishCaloriesComparator);

        int totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();

        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));

        String shortMenu = menu.stream().map(Dish::getName).collect(joining(","));

        int totalCalories1 = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        int totalCalories2 = menu.stream().map(Dish::getCalories).reduce(0, (i, j) -> i + j);

        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers = stream.reduce(
            new ArrayList<Integer>(),
            (List<Integer> l, Integer e) -> {
                l.add(e);
                return l; },
            (List<Integer> l1, List<Integer> l2) -> {
                l1.addAll(l2);
                return l1; });
        System.out.println(numbers); //[1, 2, 3, 4, 5, 6]
*/

/*
        Map<Dish.Type, List<Dish>> dishesByType =
            menu.stream().collect(groupingBy(Dish::getType));
        dishesByType.forEach((key, value) -> System.out.println(key + "=" + value));
*/

/*
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
            groupingBy(dish -> {
                if (dish.getCalories() <= 400) {
                    return CaloricLevel.DIET;
                } else if (dish.getCalories() <= 700) {
                    return CaloricLevel.NORMAL;
                } else {
                    return CaloricLevel.FAT;
                }
            }));
        dishesByCaloricLevel.forEach((key, value) -> System.out.println(key + "=" + value));
*/

/*
        Map<Dish.Type, Long> typesCount = menu.stream().collect(
            groupingBy(Dish::getType, counting()));
        typesCount.forEach((key, value) -> System.out.println(key + "=" + value));

        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
            menu.stream()
                .collect(groupingBy(Dish::getType,
                    maxBy(Comparator.comparingInt(Dish::getCalories))));
        mostCaloricByType.forEach((key, value) -> System.out.println(key + "=" + value));

        Map<Dish.Type, Integer> totalCaloriesByType =
            menu.stream().collect(groupingBy(Dish::getType,
                summingInt(Dish::getCalories)));
*/

/*
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
            menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                    dish -> {
                        if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                        else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                        else return CaloricLevel.FAT;
                    },
                    toCollection(HashSet::new))));
        caloricLevelsByType.forEach((key, value) -> System.out.println(key + "=" + value));

        Map<Boolean, List<Dish>> partitionedMenu =
            menu.stream().collect(partitioningBy(Dish::isVegetarian));
        partitionedMenu.forEach((key, value) -> System.out.println(key + "=" + value));
        List<Dish> dishes = partitionedMenu.get(true);
*/

/*
        List<Integer> list = partitionedPrime(30).get(Boolean.TRUE);
        System.out.println(list); // [1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
*/

        List<Dish> dishList = menu.stream().collect(new ToListCollector<Dish>());
        System.out.println(dishList);
    }


/*
    // 及其繁琐
    public static void groupBy(List<Transaction> transactions){
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }
    }
*/

    // 分组2~n的素数
    public static Map<Boolean, List<Integer>> partitionedPrime(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(partitioningBy(Chapter6::isPrime));
    }

    // 判断素数
    public static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        return IntStream.rangeClosed(2, sqrt).noneMatch(i -> num % i == 0);
    }
}