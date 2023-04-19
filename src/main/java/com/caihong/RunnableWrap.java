package com.caihong;

public class RunnableWrap implements Runnable {
    private final ThreadLocal<Object> threadLocal;
    private final Object context;
    private final Runnable task;

    public RunnableWrap(ThreadLocal<Object> threadLocal, Runnable task) {
        this.threadLocal = threadLocal;
        this.context = threadLocal.get();
        this.task = task;
    }

    @Override
    public void run() {
        try {
            threadLocal.set(context);
            task.run();
        } finally {
            threadLocal.remove();
        }
    }
}