package com.caihong.jianzhioffer;

// 合并两个排序的链表
public class Question25 {
    public static void main(String[] args) {
        LinkedNode<Integer> eight = new LinkedNode<>(8, null);
        LinkedNode<Integer> seven = new LinkedNode<>(7, null);
        LinkedNode<Integer> six = new LinkedNode<>(6, eight);
        LinkedNode<Integer> five = new LinkedNode<>(5, seven);
        LinkedNode<Integer> four = new LinkedNode<>(4, six);
        LinkedNode<Integer> three = new LinkedNode<>(3, five);
        LinkedNode<Integer> two = new LinkedNode<>(2, four);
        LinkedNode<Integer> one = new LinkedNode<>(1, three);
        LinkedNode<Integer> newLink = merge(one, two, 0);
        LinkedNode.print(newLink); //1 2 3 4 5 6 7 8
    }

    // 思路不对，没有写好
    //使用额外空间，sortType=0为升序，sortType=1为降序
/*    public static LinkedNode<Integer> mergeSortedLinkList(LinkedNode<Integer> one, LinkedNode<Integer> two, int sortType) {
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }
        return merge(one, two, sortType);
    }*/

    //递归求解，使用额外空间（不改变原链表），sortType=0为升序，sortType=1为降序
    private static <T extends Comparable<? super T>> LinkedNode<T> merge(LinkedNode<T> one, LinkedNode<T> two, int sortType) {
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }
        LinkedNode<T> newNode;
        if (sortType == 0) {
            if (one.getValue().compareTo(two.getValue()) <= 0) {
                newNode = one; // 应该创建新的节点
                newNode.setNext(merge(one.getNext(), two, sortType));
            } else {
                newNode = two;
                newNode.setNext(merge(one, two.getNext(), sortType));
            }
        } else {
            if (one.getValue().compareTo(two.getValue()) >= 0) {
                newNode = one;
                newNode.setNext(merge(one.getNext(), two, sortType));
            } else {
                newNode = two;
                newNode.setNext(merge(one, two.getNext(), sortType));
            }
        }
        return newNode;
    }

    private static <T extends Comparable<? super T>> LinkedNode<T> merge1(LinkedNode<T> one, LinkedNode<T> two) {
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }
        LinkedNode<T> newNode = new LinkedNode<>();
        if (one.getValue().compareTo(two.getValue()) <= 0) {
            newNode.setValue(one.getValue());
            newNode.setNext(merge1(one.getNext(), two));
        } else {
            newNode.setValue(two.getValue());
            newNode.setNext(merge1(one, two.getNext()));
        }
        return newNode;
    }
}

