package com.caihong.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierTest {
    private static CyclicBarrier barrier= new CyclicBarrier(2, new Work());

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(4);
                    barrier.await();
                    System.out.println(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        barrier.await();
        System.out.println(3);
    }

    private static class Work implements Runnable {
        @Override
        public void run() {
            System.out.println(0);
        }
    }
}
