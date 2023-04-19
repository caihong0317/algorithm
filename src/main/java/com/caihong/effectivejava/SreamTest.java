package com.caihong.effectivejava;

public class SreamTest {
    public static void main(String[] args) {
        "Hello world".chars().forEach(System.out::print);
        "Hello world".chars().forEach(x -> System.out.print((char) x));
    }
}