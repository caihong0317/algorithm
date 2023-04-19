package com.caihong.java8action.part2.chapter7;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Chapter7 {
    public static void main(String[] args) {
/*
        System.out.println("iterativeSum sum done in:" +
            measureSumPerf(Chapter7::iterativeSum, 10_000_000) + " ms"); //16
        System.out.println("Sequential sum done in:" +
            measureSumPerf(Chapter7::sequentialSum, 10_000_000) + " ms"); //175
        System.out.println("parallelSum sum done in:" +
            measureSumPerf(Chapter7::parallelSum, 10_000_000) + " ms"); //1062
*/
/*
        System.out.println("rangedSum sum done in:" +
            measureSumPerf(Chapter7::rangedSum, 10_000_000) + " ms"); //10
        System.out.println("parallelRangedSum sum done in:" +
            measureSumPerf(Chapter7::parallelRangedSum, 10_000_000) + " ms"); //3
*/
/*
        System.out.println("sideEffectSum sum done in:" +
            measureSumPerf(Chapter7::sideEffectSum, 10_000_000) + " ms"); //7
        System.out.println("parallelSideEffectSum sum done in:" +
            measureSumPerf(Chapter7::parallelSideEffectSum, 10_000_000) + " ms"); //4，更快但每次结果都不同
*/
/*
        System.out.println("parallelSideEffectSum sum done in:" +
            measureSumPerf(Chapter7::parallelSideEffectSum2, 10_000_000) + " ms"); //4，更快但每次结果都不同
*/
        System.out.println("ForkJoinSumCalculator sum done in:" +
            measureSumPerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " ms"); //41，THRESHOLD = 10000时
        //35，THRESHOLD = 1000时，并没有更快；
        System.out.println("ForkJoinSumCalculator sum done in:" +
            measureSumPerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " ms");


    }

    public static long measureSumPerf(Function<Long, Long> add, long n) {
        long time = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            long start = System.nanoTime();
            long sum = add.apply(n);
            long duration = (System.nanoTime() - start) / 1000000; //毫秒
            System.out.println(sum);
            if (time > duration) {
                time = duration;
            }
        }
        return time;
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    // 顺序求1~n的和
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    // 并行求1~n的和
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
            .reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
            .parallel().reduce(0L, Long::sum);
    }

    // 顺序执行，并行会出错
    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.getTotal();
    }

    // 顺序执行，并行会出错
    public static long parallelSideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.getTotal();
    }

    // 顺序执行，并行会出错
    public static long parallelSideEffectSum2(long n) {
        Accumulator2 accumulator = new Accumulator2();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.getTotal();
    }
}