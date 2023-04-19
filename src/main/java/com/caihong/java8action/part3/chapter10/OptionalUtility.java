package com.caihong.java8action.part3.chapter10;

import java.util.Optional;
import java.util.Map;

public class OptionalUtility {

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s, 10));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static <T, R> Optional<R> getValueForMap(Map<T, R> map, T key) {
        return Optional.ofNullable(map.get(key));
    }
}
