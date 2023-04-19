package com.caihong.effectivejava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenericTest {
    public static void main(String[] args) {
        Object[] longs = new Long[3];
        longs[0]="ok";

//        List<Object> list = new ArrayList<Long>();
        Random random = ThreadLocalRandom.current();
        int i = random.nextInt(longs.length);
    }
}
