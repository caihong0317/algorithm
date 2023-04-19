package com.caihong.effectivejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyLambda {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        Collections.sort(words, Comparator.comparingInt(String::length));
        words.sort(Comparator.comparingInt(String::length));
        }
}
