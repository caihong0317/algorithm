package com.caihong.javathinking.innerclass;

public class Sequence {
    private Object[] array;
    private int capacity;
    private int size = 0;

    public Sequence(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public void add(Object obj) {
        if (size < capacity) {
            array[size++] = obj;
        }
    }

    private Selector selector() {
        return new SequenceSelector();
    }

    private class SequenceSelector implements Selector {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object current() {
            return array[index];
        }

        @Override
        public void next() {
            if (index < size) {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 5; i++) {
            sequence.add(i);
        }
        Selector selector = sequence.selector();
        while (selector.hasNext()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}