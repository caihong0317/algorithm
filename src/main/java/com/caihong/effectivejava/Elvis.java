package com.caihong.effectivejava;

import java.io.Serializable;

public class Elvis implements Serializable {
    private Elvis() {
    }

    public static final Elvis INSTANCE = new Elvis();

    private Object readResolve() {
        return INSTANCE;
    }
}
