package com.caihong.java8action.part3.chapter8;

public class FirstProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "            Fantastic! " + input;
    }
}
