package com.caihong.effectivejava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// 换位词，普通实现
public class Anagrams1 {
    public static void main(String[] args) throws FileNotFoundException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        HashMap<String, Set<String>> groups = new HashMap<>();
        try (Scanner sc = new Scanner(dictionary)) {
            while (sc.hasNext()) {
                String word = sc.next();
                groups.computeIfAbsent(alphabetize(word), unused -> new TreeSet<>()).add(word);
            }
        }
        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + ": " + group);
//                System.out.println(group.size()+group);
            }
        }
    }

    private static String alphabetize(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}