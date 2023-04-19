package com.caihong.java8action.part2.chapter7;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.concurrent.Future;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CountWord {
    private static final String SENTENCE =
        " Nel mezzo del cammin di nostra vita " +
            "mi ritrovai in una selva oscura" +
            " ché la dritta via era smarrita ";

    public static void main(String[] args) {
        System.out.println(countWordBySplitWithSpace(SENTENCE)); //19
//        System.out.println(countWordIteratively(SENTENCE)); //19

        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        System.out.println(countWordBySplitWithSpace(SENTENCE)); //19

        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream1 = StreamSupport.stream(spliterator, true);
        //todo
    }

    public static int countWordBySplitWithSpace(String str) {
        if (str == null) {
            return 0;
        }
        //[, Nel, mezzo, del, cammin, di, nostra, vita, mi, ritrovai, in, una, selva, oscura, ché, la, dritta, via, era, smarrita]
        //String[] split = str.split(" ");
        String[] split = str.trim().split(" ");
        return split.length;
    }

    public static int countWordIteratively(String str) {
        if (str == null) {
            return 0;
        }
        int counter = 0;
        boolean lastWhite = true;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (Character.isWhitespace(c)) {
                lastWhite = true;
            } else {
                if (lastWhite) {
                    lastWhite = false;
                    counter++;
                }
            }
        }
        return counter;
    }

/*
    public int countWords(Stream<Character> stream){
        WordCounter wordCounter1 = new WordCounter(0, true);
        WordCounter result = stream.reduce(new WordCounter(0, true), wordCounter1::accumulate);
        return result.getCounter();
    }
*/
}
