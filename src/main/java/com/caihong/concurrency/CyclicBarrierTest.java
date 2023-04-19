package com.caihong.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    private static CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println(4);
        }
    });

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier.await();
                    System.out.println(1);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        });
        a.start();
        b.start();
        Thread.sleep(1000);
        barrier.await();
        System.out.println(3);
    }
}
