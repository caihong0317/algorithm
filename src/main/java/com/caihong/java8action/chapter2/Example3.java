package com.caihong.java8action.chapter2;

import com.caihong.java8action.chapter1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

// 对lambda的使用
public class Example3 {

    public static void main(String[] args) {
/*
        Predicate<String> predicate = (String s) -> !(s == null || s.isEmpty());
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add("");
        list.add("null");
        list.add("hello");
        List<String> nonEmpty = filter(list, predicate);
        System.out.println(nonEmpty);
*/

/*
        forEach(
            Arrays.asList(1, 2, 3, 4, 5),
            (Integer i) -> System.out.print(i + " ")
        );

        List<Integer> list = map(
            Arrays.asList("lambdas","in","action"),
            (String s) -> s.length());
        System.out.println(list); //[7, 2, 6]
*/

/*
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
        portNumber = 31337;
*/
/*
        List<String> str = Arrays.asList("a","b","A","B");
//        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2)); //[a, A, b, B]
        str.sort(String::compareToIgnoreCase); // [a, A, b, B]? 看不懂
        System.out.println(str);
        str.sort(String::lastIndexOf); // [B, A, b, a]? 看不懂
        System.out.println(str);
*/

/*
        Supplier<Apple> appleSupplier = Apple::new;
        Apple apple = appleSupplier.get();
        System.out.println(apple); // Apple{weight=0, color=0}

        Function<Integer, Apple> function = Apple::new;
        Apple apple1 = function.apply(150);
        System.out.println(apple1); // Apple{weight=150, color=0}
*/

/*
        List<Apple> apples = mapToApple(Arrays.asList(1, 2, 3, 4, 5), Apple::new);
        System.out.println(apples);
*/

        BiFunction<Integer, String,Apple> function= (w,c) -> new Apple(w,c);
        Apple apple2 = function.apply(150,"red");
    }

    // 自定义过滤器
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>(list.size());
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static List<Apple> mapToApple(List<Integer> weights, Function<Integer, Apple> apply) {
        List<Apple> apples = new ArrayList<>();
        if (weights != null) {
            for (Integer weight : weights) {
                apples.add(apply.apply(weight));
            }
        }
        return apples;
    }
}
