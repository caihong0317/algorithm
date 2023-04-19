package com.caihong.java8action.part3.chapter8;

public class SecondProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.replaceAll("\\s+", " ").trim();
    }
}
