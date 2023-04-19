package com.caihong.java8action.part2.chapter7;

import java.util.Spliterator;
import java.util.function.Consumer;

public class WordCounterSpliterator implements Spliterator<Character> {
    private final String str;
    private int index = 0;

    public WordCounterSpliterator(String str) {
        this.str = str;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        // 消费一个字符，遍历向前推进
        action.accept(str.charAt(index++));
        return index < str.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = str.length() - index;
        if (currentSize < 10) {
            return null;
        }
        for (int splitPos = currentSize / 2 + index; splitPos < str.length(); splitPos++) {
            if (Character.isWhitespace(str.charAt(splitPos))) {
                Spliterator<Character> spliterator = new WordCounterSpliterator(str.substring(index, splitPos));
                index = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return str.length() - index;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + NONNULL + SUBSIZED + IMMUTABLE;
    }
}
