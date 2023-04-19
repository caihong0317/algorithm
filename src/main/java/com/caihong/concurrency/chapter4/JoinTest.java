package com.caihong.concurrency.chapter4;

public class JoinTest {
    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Domino(previous, i));
            previous = thread;
            thread.start();
        }
        System.out.println("main end");
    }

    static class Domino implements Runnable {
        private int index;
        private Thread previous;

        public Domino(Thread previous, int index) {
            this.previous = previous;
            this.index = index;
        }

        @Override
        public void run() {
            try {
                previous.join();
                System.out.println(index + " " + "terminate");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
