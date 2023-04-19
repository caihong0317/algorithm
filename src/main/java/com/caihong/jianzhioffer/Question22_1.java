package com.caihong.jianzhioffer;

// 找链表中间节点
public class Question22_1 {
    public static void main(String[] args) {
        LinkedNode<Integer> seven = new LinkedNode<>(7, null);
        LinkedNode<Integer> six = new LinkedNode<>(6, seven);
        LinkedNode<Integer> five = new LinkedNode<>(5, six);
        LinkedNode<Integer> four = new LinkedNode<>(4, five);
        LinkedNode<Integer> three = new LinkedNode<>(3, four);
        LinkedNode<Integer> two = new LinkedNode<>(2, three);
        LinkedNode<Integer> one = new LinkedNode<>(1, two);
        System.out.println(findKToTail(one).getValue());
        System.out.println(findKToTail2(one).getValue());
    }

    // 两次遍历，首次获取节点数
    public static <T> LinkedNode<T> findKToTail(LinkedNode<T> root) {
        if (root == null) {
            return null;
        }
        LinkedNode<T> tmp = root;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.getNext();
        }

        LinkedNode<T> result = root;
        for (int i = 1; i < count / 2 + 1; i++) {
            result = result.getNext();
        }
        return result;
    }

    // 1次遍历
    public static <T> LinkedNode<T> findKToTail2(LinkedNode<T> root) {
        if (root == null) {
            return null;
        }
        LinkedNode<T> firstIndex = root;
        LinkedNode<T> twoIndex = root;
        while (firstIndex.getNext() != null) {
            firstIndex = firstIndex.getNext();
            if (firstIndex != null) {
                firstIndex = firstIndex.getNext();
            }
            twoIndex = twoIndex.getNext();
        }
        return twoIndex;
    }
}