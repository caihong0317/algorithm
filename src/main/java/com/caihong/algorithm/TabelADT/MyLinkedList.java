package com.caihong.algorithm.TabelADT;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    private int size;
    private int modCount = 0;
    private Node beginMarker;
    private Node endMarker;

    private class Node {
        public AnyType data;
        public Node pre;
        public Node next;

        public Node(AnyType data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    // index 从0开始
    public Node getNode(int index, int lower, int upper) {
        Node pointer;
        if (index < lower || index > upper) {

        }

        if (index < size / 2) {
            pointer = beginMarker;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next;
            }
        } else {
            pointer = endMarker;
            for (int i = size; i > index; i--) {
             pointer = pointer.pre;
            }
        }
        return pointer;
    }

    public AnyType remove(Node p){
        p.pre.next=p.next;
        p.next.pre=p.pre;
        size--;
        modCount++;
        return p.data;
    }
    // 返回迭代器
    public java.util.Iterator<AnyType> iterator(){
        //为什么报错
        return new LinkedListIterator();
    }

    //内部类，可直接访问size和items
    private class LinkedListIterator implements Iterator<AnyType>{

        private Node current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current!=endMarker;
        }

        @Override
        public AnyType next() {
            // 这个判断能不能去掉
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            AnyType data = current.data;
            current=current.next;
            okToRemove =true;
            return data;
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            if (okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.pre);
            expectedModCount++;
            okToRemove=false;
        }

        @Override
        public void forEachRemaining(Consumer<? super AnyType> action) {

        }
    }

    @Override
    public void forEach(Consumer<? super AnyType> action) {

    }

    @Override
    public Spliterator<AnyType> spliterator() {
        return null;
    }

}
