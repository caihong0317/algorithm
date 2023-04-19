package com.caihong.concurrency;

import com.caihong.java8action.part2.chapter7.ForkJoinSumCalculator;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;
import java.util.stream.LongStream;

/**
 * 采用ForkJoin来计算求和
 * * @author fangshixiang@vipkid.com.cn
 *
 * @description //
 * @date 2018/11/5 15:09
 */
public class ForkJoinCalculator implements Calculator {

    private ForkJoinPool pool;
    private static int threshold;

    //执行任务RecursiveTask：有返回值  RecursiveAction：无返回值
    private static class SumTask extends RecursiveTask<Long> {
        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        //此方法为ForkJoin的核心方法：对任务进行拆分  拆分的好坏决定了效率的高低
        @Override
        protected Long compute() {
            long total = 0;
            // 当需要计算的数字个数小于6时，直接采用for loop方式计算结果
            if (to - from < threshold) {
                for (int i = from; i <= to; i++) {
                    total += numbers[i];
                }
            } else { // 否则，把任务一分为二，递归拆分(注意此处有递归)到底拆分成多少分 需要根据具体情况而定
                int middle = (from + to) / 2;
                SumTask taskLeft = new SumTask(numbers, from, middle);
                SumTask taskRight = new SumTask(numbers, middle + 1, to);
                taskLeft.fork();
                taskRight.fork();
                total = taskLeft.join() + taskRight.join();
            }
            return total;
        }
    }

    public ForkJoinCalculator(int threshold) {
        this.threshold = threshold;
        // 也可以使用公用的线程池 ForkJoinPool.commonPool()：
        // pool = ForkJoinPool.commonPool()
        pool = new ForkJoinPool();
        System.out.println("initiated pool.getPoolSize()=" + pool.getPoolSize());
    }

    @Override
    public long sumUp(long[] numbers) {
        SumTask task = new SumTask(numbers, 0, numbers.length - 1);
        Long result = pool.invoke(task);
        System.out.println("finally pool.getPoolSize()=" + pool.getPoolSize());
        return result;
        /*
        Future<Long> result = pool.submit(task);
        pool.shutdown();
        try {
            return result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return 0;
         */
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

/*
        Calculator calculator = new ForkJoinCalculator(150);
        Instant start = Instant.now();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms"); //10-366,100-179,200-230
        System.out.println("结果为：" + result);
*/

/*
        ForkJoinPool pool = new ForkJoinPool();
        Instant start = Instant.now();
        Long result = pool.invoke(new ForkJoinSumCalculator(numbers));
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");
        System.out.println("结果为：" + result);
*/

        Instant start = Instant.now();
        long result = ForkJoinSumCalculator.forkJoinSum(10000000);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms"); // 99
        System.out.println("结果为：" + result);
    }
}