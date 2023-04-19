package com.caihong.java8action.part2.chapter7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private long[] array;
    private int start;
    private int end;
    private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();
    private static final int THRESHOLD = 1000;


    public ForkJoinSumCalculator(long[] array) {
        this(array, 0, array.length - 1);
    }

    public ForkJoinSumCalculator(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public static long forkJoinSum(long n) {
        long[] array = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(array);
        return FORK_JOIN_POOL.invoke(task);
    }

    @Override
    protected Long compute() {
        int length = start - end + 1;
        if (length < THRESHOLD) {
            return computeSequentially(array, start, end);
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(array, start, start + length / 2);
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(array, start + length / 2 + 1, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    // 顺序求和
    private Long computeSequentially(long[] array, int start, int end) {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += array[i];
        }
        return sum;
    }
}