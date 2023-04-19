package com.caihong.concurrency.c5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueue<T> {
    private Object[] items;
    private int addIndex, removeIndex, count;
    private static final Lock LOCK = new ReentrantLock();
    private static final Condition NOT_FULL = LOCK.newCondition();
    private static final Condition NOT_EMPTY = LOCK.newCondition();

    public BlockedQueue(int size) {
        items = new Object[size];
    }

    public void add(T item) throws InterruptedException {
        LOCK.lock();
        try {
            while (count == items.length) {
                NOT_FULL.await();
            }
            items[addIndex] = item;
            count++;
            if (++addIndex == items.length) {
                addIndex = 0;
            }
            NOT_EMPTY.signal();
        } finally {
            LOCK.unlock();
        }
    }

    public T remove() throws InterruptedException {
        LOCK.lock();
        try {
            while (count == 0) {
                NOT_EMPTY.await();
            }
            Object obj = items[removeIndex];
            count--;
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }
            NOT_FULL.signal();
            return (T) obj;
        } finally {
            LOCK.unlock();
        }
    }
}
