package com.caihong.java8action.part2.chapter6;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class PrimeNumbersCollector implements Collector<Integer,
    Map<Boolean, List<Integer>>,
    Map<Boolean, List<Integer>>> {

    public static void main(String[] args) {
        long time1 = generatePrimesByCustom();
        long time2 = generatePrimes();
        System.out.println((time2-time1)*1.0/time2); //-0.063?
    }

    // 使用自定义收集器
    private static long generatePrimesByCustom() {
        long minTime = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            long start = System.nanoTime();
            IntStream.rangeClosed(2, 1000000).boxed().collect(new PrimeNumbersCollector());
            long time = System.nanoTime() - start;
            if (time < minTime) {
                minTime = time;
            }
        }
        return minTime;
    }

    // 使用库定义收集器
    private static long generatePrimes() {
        long minTime = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            long start = System.nanoTime();
            Chapter6.partitionedPrime(1000000);
            long time = System.nanoTime() - start;
            if (time < minTime) {
                minTime = time;
            }
        }
        return minTime;
    }

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<>() {
            {
                put(true, new ArrayList<>());
                put(false, new ArrayList<>());
            }
        };
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> map, Integer n) -> map.get(isPrime(map.get(true), n)).add(n);
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> map1,
                Map<Boolean, List<Integer>> map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    // 截取质数列表的一部分
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return takeWhile(primes, i -> i <= candidateRoot)
            .stream()
            .noneMatch(p -> candidate % p == 0);
    }
}