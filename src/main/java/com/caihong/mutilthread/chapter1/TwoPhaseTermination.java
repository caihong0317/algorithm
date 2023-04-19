package com.caihong.mutilthread.chapter1;

public class TwoPhaseTermination {
    private Thread monitorThread;
    private volatile boolean stop;
    private volatile boolean started;

    public TwoPhaseTermination() {
        this.stop = false;
        this.started = false;
    }

    public void start() {
        synchronized (this) {
            if (started) {
                return;
            }
            started = true; // 关键
            stop = false;
        }
        monitorThread = new Thread(() -> {
            while (true) {
                if (stop) {
                    System.out.println("善后...");
                    started = false;
                    return;
                }
                Thread.yield();
            }
        });
        monitorThread.start();
    }

    public void stop() {
        stop = true;
    }

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();
        twoPhaseTermination.start();
        twoPhaseTermination.start();

        Thread.sleep(2000);
        System.out.println("停止");
        twoPhaseTermination.stop();

        Thread.sleep(1000);
        twoPhaseTermination.start();
        System.out.println("停止");
        twoPhaseTermination.stop();

    }
}
