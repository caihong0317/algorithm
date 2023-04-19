package com.caihong.javathinking.generictype;

// 链式堆栈的实现
public class LinkedStack<T> {
    private Node<T> top = new Node<>();

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.isEnd()) {
            top = top.next;
        }
        return result;
    }

    public T peek() {
        return top.item;
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        Node() {
            item = null;
            next = null;
        }

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        boolean isEnd() {
            return item == null && next == null;
        }
    }
}