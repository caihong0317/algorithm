package com.caihong.concurrency;

import java.util.concurrent.*;

public class RejectedPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

    }


    private ThreadPoolExecutor poolExecutor =  new ThreadPoolExecutor(5,10,
        60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(200), this);

    public static void main(String[] args) {
        RejectedPolicy rejectedPolicy = new RejectedPolicy();
        System.out.println("ok");
    }
}
