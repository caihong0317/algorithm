package com.caihong.javaVM.oom;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC hock = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize executed");
        hock = this;
    }

    public static void main(String[] args) throws InterruptedException {
        hock = new FinalizeEscapeGC();
        hock = null;
        System.gc();
        Thread.sleep(500);
        if (hock != null) {
            System.out.println("alive");
        } else {
            System.out.println("dead");
        }

        hock = null;
        System.gc();
        Thread.sleep(500);
        if (hock != null) {
            System.out.println("alive");
        } else {
            System.out.println("dead");
        }
    }
}
