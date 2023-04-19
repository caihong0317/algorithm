package com.caihong.jianzhioffer;

import static com.caihong.jianzhioffer.Question17.printToMaxOfDigits;

//删除链表节点，O(1)实现
public class Question18_1 {

    public static void main(String[] args) {

    }

    public static <T> void deleteNode(LinkedNode<T> root, LinkedNode<T> target) {
        if (root == null || target == null) {
            return;
        }
        LinkedNode<T> tmp = root;
        LinkedNode<T> next = target.getNext();
        // 中间节点
        if (next != null) {
            target.setValue(next.getValue());
            target.setNext(next.getNext());
        } else {
            // 只有一个节点
            if (root == target) {
                root = null;
            }
            // tail节点
            while (tmp.getNext() != target) {
                tmp = tmp.getNext();
            }
            tmp.setNext(null);
        }
    }

    // 覆盖target
    public static <T> void deleteNode2(LinkedNode<T> root, LinkedNode<T> target) {
        if (root == null || target == null) {
            return;
        }
        LinkedNode<T> temp = root;
        LinkedNode<T> next = target.getNext();
        if (next != null) { // 中间节点
            target.setNext(next.getNext());
            target.setNext(next.getNext());
        } else {
            if (root == target) { // 根节点
                root = null;
            }
            while (temp.getNext() != target) { // 尾节点
                temp = temp.getNext();
            }
            temp.setNext(null);
        }
    }
}