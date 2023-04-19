package com.caihong.javathinking.container;

public class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeType obj) {
        return obj.i < i ? -1 : (obj.i == i ? 0 : 1);
    }
}
