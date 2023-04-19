package com.caihong.effectivejava;

import java.time.Instant;

public final class Sub extends Super implements Cloneable{
    private final Instant instant;

    Sub() {
//        super();
        this.instant = Instant.now();
    }

    @Override
    public void method() {
        int nano = instant.getNano();
        System.out.println(nano);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.method();
    }
}
