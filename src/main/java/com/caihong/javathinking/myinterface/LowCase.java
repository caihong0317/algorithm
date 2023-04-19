package com.caihong.javathinking.myinterface;

import java.util.Locale;

public class LowCase extends StringProcessor{
    @Override
    public Object process(Object input) {
        return input.toString().toLowerCase(Locale.ENGLISH);
    }
}
