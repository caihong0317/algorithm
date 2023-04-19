package com.caihong.java8action.part2.chapter7;

public class Accumulator {
    private long total = 0;

    public void add(long i) {
        total += i;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
