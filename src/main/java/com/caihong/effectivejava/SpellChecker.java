package com.caihong.effectivejava;

import java.util.Objects;

public class SpellChecker<T> {
    private final T dictionary;

    public SpellChecker(T dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return true;
    }
}
