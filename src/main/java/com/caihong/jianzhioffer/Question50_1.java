package com.caihong.jianzhioffer;

import java.util.LinkedHashMap;
import java.util.Map;

// 联机算法
public class Question50_1 {
    private static final Map<Character, Integer> MAP = new LinkedHashMap<>();
    private static final StringBuilder BUILDER = new StringBuilder();

    public static void main(String[] args) {
        insert('g');
        insert('o');
        insert('o');
        System.out.println(findFirstOnlyOne());
        insert('g');
        insert('l');
        System.out.println(findFirstOnlyOne());
        System.out.println(BUILDER.toString());
    }

    synchronized public static void insert(char aChar) {
        BUILDER.append(aChar);
        putMap(aChar);
    }

    private static void putMap(char aChar) {
        Integer integer = MAP.get(aChar);
        if (integer == null) {
            MAP.put(aChar, 1);
        } else {
            MAP.remove(aChar);
        }
    }

    synchronized public static char findFirstOnlyOne() {
        for (Character character : MAP.keySet()) {
            return character;
        }
        return '0';
    }
}
