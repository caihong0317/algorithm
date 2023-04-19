package com.caihong.concurrency.chapter4;

import java.util.ArrayList;
import java.util.List;

public class PriorityTest {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int priority = i < 3 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            list.add(job);
            new Thread(job).start();
        }
        notStart = false;
        Thread.sleep(2000);
        notEnd = false;

        // 结果有违直觉
        for (Job job : list) {
            System.out.println(job.getPriority() + ": " + job.getCount());
        }
    }

    static class Job implements Runnable {
        private int priority;
        private long count = 0;

        public Job(int priority) {
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }

        public long getCount() {
            return count;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                count++;
            }
        }
    }
}
