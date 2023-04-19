package com.caihong.designpattern.Iterator;

public class ConcreteIterator implements Iterator {
    private Aggregate aggregate;
    private int cursor = 0;

    public ConcreteIterator(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public boolean hasNext() {
        return cursor < aggregate.size();
    }

    @Override
    public Object next() {
        return aggregate.get(cursor++);
    }
}
