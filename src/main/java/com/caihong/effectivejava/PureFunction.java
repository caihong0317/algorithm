package com.caihong.effectivejava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PureFunction {
    public static void main(String[] args) {
        File file = new File("d://1.txt");
        final Map<String, Long> freq;

        try (Stream<String> words = new Scanner(file).tokens()) {
            // words.forEach(word -> freq.merge(word.toLowerCase(Locale.ENGLISH), 1L, Long::sum)); // 不好
            freq = words.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

            List<String> topTen = freq.keySet().stream()
                .sorted(Comparator.comparing(freq::get).reversed())
                .limit(10)
                .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
