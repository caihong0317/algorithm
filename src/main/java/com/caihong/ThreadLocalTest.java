package com.caihong;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadLocalTest {
    private static TransmittableThreadLocal<String> CONTEXT = new TransmittableThreadLocal<>();
    // 使用只有一个线程的线程池，测试线程复用是否影响TransmittableThreadLocal的效果
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(1);

    // 使用只有一个线程的线程池，测试线程复用是否影响TransmittableThreadLocal的效果
    private static final Executor TTL_EXECUTOR = TtlExecutors.getTtlExecutor(Executors.newFixedThreadPool(1));

    public static void main(String[] args) throws InterruptedException {
//        testTtlRunnable();
        testTtlExecutors();
    }

    private static void testTtlRunnable() {
        // 设置主线程的上下文为"china"
        CONTEXT.set("china");
        // 创建第一个任务，通过TtlRunnable.get()包装；
        // 在第一个任务中查看上下文数据，检查是否拿到正确的上下文；
        // 另外再修改掉该上下文，主要测试是否会影响第二个任务的上下文；
        Runnable task1 = TtlRunnable.get(() -> {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "开始");
            String countryCode = CONTEXT.get();
            System.out.println("第一个任务执行结果：" + countryCode);
            // 修改该线程中上下文值，检查是否影响第二个任务
            CONTEXT.set("US");
            System.out.println(thread.getName() + "结束");
        });

        // 第二个任务主要测试上下文是否受第一个任务的影响
        Runnable task2 = TtlRunnable.get(() -> {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "开始");
            String countryCode = CONTEXT.get();
            System.out.println("第二个任务执行结果：" + countryCode);
            System.out.println(thread.getName() + "结束");
        });

        // 按顺序执行两个任务，全部放到线程池中执行
        CompletableFuture.runAsync(task1, EXECUTOR)
                .thenRunAsync(task2, EXECUTOR);

        // 检查主线程上下文是否受影响；
        String countryCode = CONTEXT.get();
        System.out.println("主线程执行结果：" + countryCode);
    }

    public static void testTtlExecutors() {
        // 设置主线程的上下文为"china"
        CONTEXT.set("china");
        // 创建第一个任务，通过TtlRunnable.get()包装；
        // 在第一个任务中查看上下文数据，检查是否拿到正确的上下文；
        // 另外再修改掉该上下文，主要测试是否会影响第二个任务的上下文；
        Runnable task1 = () -> {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "开始");
            String countryCode = CONTEXT.get();
            System.out.println("第一个任务执行结果：" + countryCode);
            // 修改该线程中上下文值，检查是否影响第二个任务
            CONTEXT.set("US");
            System.out.println(thread.getName() + "结束");
        };
        // 第二个任务主要测试上下文是否受第一个任务的影响
        Runnable task2 = () -> {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "开始");
            String countryCode = CONTEXT.get();
            System.out.println("第二个任务执行结果：" + countryCode);
            System.out.println(thread.getName() + "结束");
        };

        // 按顺序执行两个任务，全部放到线程池中执行
        CompletableFuture.runAsync(task1, TTL_EXECUTOR)
                .thenRunAsync(task2, TTL_EXECUTOR);
        // 检查主线程上下文是否受影响；
        String countryCode = CONTEXT.get();
        System.out.println("主线程执行结果：" + countryCode);
    }
}
