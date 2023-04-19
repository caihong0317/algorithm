package com.caihong.java8action.chapter1;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

    default void consumer(T t){

    }
}
