package com.caihong.jianzhioffer;

public class Question22 {
    public static void main(String[] args) {
        LinkedNode<Integer> seven = new LinkedNode<>(7, null);
        LinkedNode<Integer> six = new LinkedNode<>(6, seven);
        LinkedNode<Integer> five = new LinkedNode<>(5, six);
        LinkedNode<Integer> four = new LinkedNode<>(4, five);
        LinkedNode<Integer> three = new LinkedNode<>(3, four);
        LinkedNode<Integer> two = new LinkedNode<>(2, three);
        LinkedNode<Integer> one = new LinkedNode<>(1, two);
        System.out.println(findKToTail(one, 5).getValue());
        System.out.println(findKToTail(null, 3));
        System.out.println(findKToTail(null, 9));
        System.out.println(findKToTail2(one, 5).getValue());
        System.out.println(findKToTail2(null, 3));
        System.out.println(findKToTail2(null, 9));
    }

    // 两次遍历，首次获取节点数
    public static <T> LinkedNode<T> findKToTail(LinkedNode<T> root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        LinkedNode<T> tmp = root;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.getNext();
        }
        if (k > count) {
            return null;
        }

        LinkedNode<T> result = root;
        for (int i = 1; i < count - k + 1; i++) {
            result = result.getNext();
        }
        return result;
    }

    // 1次遍历
    public static <T> LinkedNode<T> findKToTail2(LinkedNode<T> root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        LinkedNode<T> firstIndex = root;
        LinkedNode<T> twoIndex = root;
        // 注意界限
        for (int i = 1; i < k; i++) {
            firstIndex = firstIndex.getNext();
            if (firstIndex == null) {
                return null;
            }
        }
        //用firstIndex!= null会多走一步，firstIndex为尾节点时终止
        while (firstIndex.getNext() != null) {
            firstIndex = firstIndex.getNext();
            twoIndex = twoIndex.getNext();
        }
        return twoIndex;
    }
}
