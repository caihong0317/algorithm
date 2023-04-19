package com.caihong.java8action.part2.chapter7;

import java.util.stream.Stream;

public class WordCounter {
    private final int counter;
    private final boolean lastSpace;

/*
    // 属性为final时，不能有无参构造器
    public WordCounter() {
    }
*/

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

/*
    public int countWords(Stream<Character> stream){
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate);
        return wordCounter.getCounter();
    }
*/

    // 累加
    public WordCounter accumulate(Character c){
        if(Character.isWhitespace(c)){
           return lastSpace?this:new WordCounter(counter,true);
        }else {
            return lastSpace? new WordCounter(counter+1,false):this;
        }
    }

    // 并行合并
    public WordCounter combine(WordCounter wordCounter){
        return new WordCounter(counter+wordCounter.counter,lastSpace);
    }

    public int getCounter() {
        return counter;
    }
}
