package com.caihong.designpattern.Iterator;

public class AggregateA implements Aggregate {
    private Object[] items;

    public AggregateA() {
        items = new Object[10];
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public Object get(int index) {
        return items[index];
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
}
