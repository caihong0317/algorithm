package com.caihong.concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * @Author: chengc
 * @Date: 2020/8/28 下午5:11
 * 并行流底层还是Fork/Join框架，只是任务拆分优化得很好。
 */
public class LambdaStreamCalculator {
    public static void main(String[] args) {
        Instant start = Instant.now();
        long result = LongStream
            .rangeClosed(0, 10000000L)
            // parallelStream其实就是一个并行执行的流.
            // 它底层通过默认的ForkJoinPool,可能提高你的多线程任务的速度.
            .parallel()
            .reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");// 73
        System.out.println("结果为：" + result);
    }
}