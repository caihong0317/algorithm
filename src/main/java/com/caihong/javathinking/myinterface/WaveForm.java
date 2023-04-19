package com.caihong.javathinking.myinterface;

public class WaveForm {
    private static long counter=0;
    private final long id=counter++;

    @Override
    public String toString() {
        return "WaveForm" +
            "id=" + id +
            '}';
    }
}
