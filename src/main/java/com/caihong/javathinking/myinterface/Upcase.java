package com.caihong.javathinking.myinterface;

import java.util.Locale;

public class Upcase extends StringProcessor {
    @Override
    public Object process(Object input) {
        return input.toString().toUpperCase(Locale.ENGLISH);
    }
}
