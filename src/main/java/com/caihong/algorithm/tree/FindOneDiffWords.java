package com.caihong.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// 算法优化
public class FindOneDiffWords {

    // 方式3, 先按单词长度分组，然后截取，1秒
    public static Map<String, List<String>> adjacentWords3(List<String> allWords) {
        Map<String, List<String>> adjWords = new TreeMap<>();
        Map<Integer, List<String>> groupWords = new TreeMap<>();

        for (String word : allWords) {
            update(groupWords, word.length(), word);
        }

        for (Map.Entry<Integer, List<String>> entry : groupWords.entrySet()) {
            // 注意位置
            Map<String, List<String>> repWords = new TreeMap<>();
            int num = entry.getKey();
            List<String> words = entry.getValue();
            for (String word : words) {
                for (int i = 0; i < num; i++) {
                    String rep = word.substring(0, i) + word.substring(i + 1, num);
                    update(repWords,rep, word);

                }
            }

            for (List<String> list : repWords.values()) {
                // 补充判断
                if (list.size()>1) {
                    for (String word1 : list) {
                        for (String word2 : list) {
                            if (word1!=word2) {
                                update(adjWords,word1,word2);
                            }
                        }
                    }
                }
            }
        }
        return adjWords;
    }

        // 方式2, 先按单词长度分组，16秒
    public static Map<String, List<String>> adjacentWords2(List<String> allWords) {
        Map<String, List<String>> adjWords = new TreeMap<>();
        Map<Integer, List<String>> groupWords = new TreeMap<>();
        //对word不可消费两次
        //adjWords.forEach(word -> update(groupWords, word.length(), word));

        for (String word : allWords) {
            update(groupWords, word.length(), word);
        }

        String word1, word2;
        for (List<String> words : groupWords.values()) {
            for (int i = 0; i < words.size(); i++) {
                word1 = words.get(i);
                for (int j = i + 1; j < words.size(); j++) {
                    word2 = words.get(j);
                    if (oneCharDiff(word1, word2)) {
                        update(adjWords, word1, word2);
                        update(adjWords, word2, word1);
                    }
                }
            }
        }
        return adjWords;
    }

    // 方式1, O(N^2), 75秒
    public static Map<String, List<String>> adjacentWords1(List<String> allWords) {
        Map<String, List<String>> adjWords = new TreeMap<>();

        // 转为数字非必要
        String[] words = new String[allWords.size()];
        allWords.toArray(words);

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (oneCharDiff(words[i], words[j])) {
                    update(adjWords, words[i], words[j]);
                    update(adjWords, words[j], words[i]);
                }
            }
        }
        return adjWords;
    }

    //
    private static boolean oneCharDiff(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int diffNum = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffNum++;
                if (diffNum > 1) {
                    return false;
                }
            }
        }
        return diffNum == 1;
    }

    // 更新结果集
    private static <K> void update(Map<K, List<String>> adjWords, K key, String value) {
        List<String> words = adjWords.get(key);
        if (words == null) {
            words = new ArrayList<String>();
            adjWords.put(key, words);
        }
        words.add(value);
    }

    // 打印
    public static void printResult(Map<String, List<String>> adjWords, int minNum) {
        for (Map.Entry<String, List<String>> entry : adjWords.entrySet()) {
            List<String> words = entry.getValue();
            int size = words.size();
            if (size >= minNum) {
                System.out.print(entry.getKey() + size + ":");
                for (String word : words) {
                    System.out.print(" " + word);
                }
                // 换行
                System.out.println();
            }
        }
    }
}
