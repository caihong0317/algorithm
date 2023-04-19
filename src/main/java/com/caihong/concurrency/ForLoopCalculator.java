package com.caihong.concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * 通过普通的for循环 实现总和的相加 逻辑非常简单
 *  * @author fangshixiang@vipkid.com.cn
 * @description //
 * @date 2018/11/5 14:31
 */
public class ForLoopCalculator implements Calculator {

    @Override
    public long sumUp(long[] numbers) {
        long total = 0;
        for (long i : numbers) {
            total += i;
        }
        return total;
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();
        Calculator calculator = new ForLoopCalculator();
        Instant start = Instant.now();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms"); // 12
        System.out.println("结果为：" + result);
    }
}
