package com.caihong.java8action.part2.chapter6;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 生产流
public class Example4 {
    public static void main(String[] args) {
/*
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
*/
/*
        long total = totalOfUniqueWords("d:/words.txt");
        System.out.println(total); //98

        Map<String, Integer> map = totalOfWords("d:/words.txt");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
*/

/*
        Stream.iterate(0, n -> n + 2)
            .limit(10)
            .forEach(t -> System.out.print(t + " "));
*/

/*
        // 菲薄那些，很麻烦
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1],})
            .limit(10)
            .map(t -> t[0])
            .forEach(t -> System.out.print(t + " "));
*/

/*
        Stream.generate(Math::random)
            .limit(5)
            .forEach(System.out::println);
*/

        IntStream twos = IntStream.generate(new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        });
        twos.limit(10).forEach(t -> System.out.print(t + " "));

    }

    // 单词数量（去重）
    public static long totalOfUniqueWords(String path) {
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get(path), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();
        } catch (IOException e) {

        }
        return uniqueWords;
    }

    public static Map<String, Integer> totalOfWords(String path) {
        Map<String, Integer> map = new HashMap<>();
        try (Stream<String> lines = Files.lines(Paths.get(path), Charset.defaultCharset())) {
            Map<String, List<String>> collect = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                .collect(Collectors.groupingBy(s -> s));

            for (Map.Entry<String, List<String>> entry : collect.entrySet()) {
                map.put(entry.getKey(), entry.getValue().size());
            }
        } catch (IOException e) {

        }
        return map;
    }
}
