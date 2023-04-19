package com.caihong.jianzhioffer;

//删除链表中有重复的节点
public class Question18_2 {

    public static void main(String[] args) {
        LinkedNode<Integer> five = new LinkedNode<>(5, null);
        LinkedNode<Integer> four1 = new LinkedNode<>(4, five);
        LinkedNode<Integer> four2 = new LinkedNode<>(4, four1);
        LinkedNode<Integer> three1 = new LinkedNode<>(3, four2);
        LinkedNode<Integer> three2 = new LinkedNode<>(3, three1);
        LinkedNode<Integer> two = new LinkedNode<>(2, three2);
        LinkedNode<Integer> one = new LinkedNode<>(1, two);
        LinkedNode.print(one); // 1 2 3 3 4 4 5
        deleteDuplication(one);
        LinkedNode.print(one); //1 2 5
    }

    // 不好写
    public static <T> void deleteDuplication(LinkedNode<T> root) {
        if (root == null) {
            return;
        }
        LinkedNode<T> preNode = null;

        LinkedNode<T> node = root;
        while (node != null) {
            //isFindDuplicate不能定义在while外面
            boolean isFindDuplicate = false;
            LinkedNode<T> next = node.getNext();
            if (next != null && node.getValue() == next.getValue()) {
                isFindDuplicate = true;
            }
            // 无重复时推进
            if (!isFindDuplicate) {
                preNode = node;
                node = next;
            } else {
                //值相等时，找到下一个值不相等的节点或者直到尾节点
                T value = node.getValue();
                LinkedNode<T> tmp = next.getNext();
                while (tmp != null && tmp.getValue() == value) {
                    //推进
                    next = tmp;
                    tmp = tmp.getNext();
                }
                if (preNode == null) {
                    // root节点将被删除
                    preNode = next;
                } else {
                    //到达尾节点
                    if (tmp == null) {
                        preNode.setNext(next);
                        return;
                    } else {
                        preNode.setNext(tmp);
                        node = tmp;
                    }
                }
            }
        }
    }
}