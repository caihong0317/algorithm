package com.caihong.jianzhioffer;

public class LinkedNode<T> {
    private T value;
    private LinkedNode<T> next;
    private LinkedNode<T> sibling; // 可作为前一节点

    public LinkedNode() {
    }

    public LinkedNode(T value, LinkedNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public LinkedNode(T value, LinkedNode<T> next, LinkedNode<T> sibling) {
        this.value = value;
        this.next = next;
        this.sibling = sibling;
    }

    public LinkedNode<T> getSibling() {
        return sibling;
    }

    public void setSibling(LinkedNode<T> sibling) {
        this.sibling = sibling;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public static <T> void print(LinkedNode<T> root) {
        LinkedNode<T> tmp = root;
        while (tmp != null) {
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    // 复制链表
    public static <T> LinkedNode<T> copyLinkedList(LinkedNode<T> linkedNode) {
        if (linkedNode == null) {
            return null;
        }
        // 复制首节点
        LinkedNode<T> copy = new LinkedNode<>();
        copy.setValue(linkedNode.getValue());
        copy.setNext(null);

        LinkedNode<T> copyTmp=copy;
        LinkedNode<T> tmp = linkedNode.getNext();
        while (tmp != null) {
            LinkedNode<T> copyNode = new LinkedNode<>();
            copyNode.setValue(tmp.getValue());
            copyNode.setNext(null);
            copyTmp.setNext(copyNode);
            tmp = tmp.getNext();
            copyTmp = copyNode;
        }
        return copy;
    }

    // 将链表中偶数位分离，使原链表只有奇数位，并返回偶数位形成的链表，
    private static <T> LinkedNode<T> separateOddEven(LinkedNode<T> linkedNode) {
        if (linkedNode == null || linkedNode.getNext() == null) {
            return null;
        }
        // 有两个以上节点时，分离前两个节点
        LinkedNode<T> copyNode = linkedNode.getNext();
        LinkedNode<T> copy = copyNode;
        LinkedNode<T> tmp = copy.getNext();
        linkedNode.setNext(tmp);

        while (tmp != null) {
            copy.setNext(tmp.getNext());
            copy = copy.getNext();
            if (copy != null) {
                tmp.setNext(copy.getNext());
                tmp = tmp.getNext();
            } else {
                break;
            }
        }
        return copyNode;
    }

    public static void main(String[] args) {
        LinkedNode<Integer> seven = new LinkedNode<>(7, null);
        LinkedNode<Integer> six = new LinkedNode<>(6, seven);
        LinkedNode<Integer> five = new LinkedNode<>(5, six);
        LinkedNode<Integer> four = new LinkedNode<>(4, five);
        LinkedNode<Integer> three = new LinkedNode<>(3, four);
        LinkedNode<Integer> two = new LinkedNode<>(2, three);
        LinkedNode<Integer> one = new LinkedNode<>(1, two);
//        LinkedNode<Integer> even = separateOddEven(one);
//        print(one); // 1 3 5 7
//        print(even); // 2 4 6
        LinkedNode<Integer> copyLinkedList = copyLinkedList(one);
        print(copyLinkedList); // 1 2 3 4 5 6 7
    }
}