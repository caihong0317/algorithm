package com.caihong.ApiLearn;

import java.util.Comparator;

class MyComparators {

    private MyComparators() {
        throw new AssertionError("no instance");
    }

    public enum NaturalOrderComparator implements Comparator<Comparable<Object>>{
        INSTANCE;

        @Override
        public int compare(Comparable<Object> o1, Comparable<Object> o2) {
            return o1.compareTo(o2);
        }

        @Override
        public Comparator<Comparable<Object>> reversed() {
            return Comparator.reverseOrder();
        }
    }

    // NPE 安全的Comparator
    static final class NullComparator<T> implements Comparator<T> {

        private static final long serailVersionUID = -1000;
        private final boolean nullFirst;
        // if null, non-null Ts are considered equal
        private final Comparator<T> real;

        public NullComparator(boolean nullFirst, Comparator<T> real) {
            this.nullFirst = nullFirst;
            this.real = real;
        }

        @Override
        public int compare(T a, T b) {
            if (a == null) {
                return b == null ? 0 : (nullFirst ? -1 : 1);
            } else if (b == null) {
                return nullFirst ? 1 : -1;
            } else {
                return real == null ? 0 : real.compare(a, b);
            }
        }

        @Override
        public Comparator<T> reversed() {
            return new NullComparator<T>(!nullFirst, real==null ? null:real.reversed());
        }

        // 与上效果同
        public Comparator<T> reversed2() {
            boolean flag = !this.nullFirst;
            Comparator<T> newCop = real == null ? null : real.reversed();
            return new NullComparator<T>(flag,newCop);
        }
    }
}
