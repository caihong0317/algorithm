package com.caihong.javathinking.generictype;

public class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
            "first=" + first +
            ", second=" + second +
            '}';
    }


    public static void main(String[] args) {
        TwoTuple<Integer, String> tuple = new TwoTuple<>(100, "hello");
        System.out.println(tuple);
    }
}