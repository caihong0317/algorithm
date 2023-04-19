package com.caihong.jianzhioffer;

import java.util.LinkedHashMap;
import java.util.Map;

public class Question50 {
    public static void main(String[] args) {
        String str = "abaccdeffb";
        System.out.println(findFirstOnlyOne(str)); // b
    }

    public static char findFirstOnlyOne(String str) {
        if (str == null || str.length() == 0) {
            return '0';
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            Integer integer = map.get(aChar);
            if (integer == null) {
                map.put(aChar, 1);
            } else {
                map.remove(aChar);
            }
        }
        for (Character character : map.keySet()) {
            return character;
        }
        return '0';
    }
}
