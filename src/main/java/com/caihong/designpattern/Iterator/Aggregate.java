package com.caihong.designpattern.Iterator;

public interface Aggregate {
    Iterator createIterator();
    int size();
    Object get(int index);
}
