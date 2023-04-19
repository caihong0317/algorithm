package com.caihong.javathinking.container;

import java.util.Objects;

public class SetType {
    protected int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SetType setType = (SetType) o;
        return i == setType.i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
