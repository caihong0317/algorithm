package com.caihong.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

// 找链表中环的入口节点
public class Question23 {
    public static void main(String[] args) {
        LinkedNode<Integer> seven = new LinkedNode<>(7, null);
        LinkedNode<Integer> six = new LinkedNode<>(6, seven);
        LinkedNode<Integer> five = new LinkedNode<>(5, six);
        LinkedNode<Integer> four = new LinkedNode<>(4, five);
        LinkedNode<Integer> three = new LinkedNode<>(3, four);
        LinkedNode<Integer> two = new LinkedNode<>(2, three);
        LinkedNode<Integer> one = new LinkedNode<>(1, two);
        seven.setNext(three);
        LinkedNode<Integer> entryNode = getEntryNodeOfLoop(one);
        if (entryNode != null) {
            System.out.println(entryNode.getValue()); //3
        } else {
            System.out.println("链表中没有环");
        }

        System.out.println(getNodeCount(one)); //7
    }

    // 判断链表中是否存在环
    public static <T> LinkedNode<T> getMeetingNode(LinkedNode<T> root) {
        if (root == null) {
            return null;
        }
        LinkedNode<T> fast = root.getNext();
        // 仅一个节点，无环
        if (fast == null) {
            return null;
        }
        // slow的初始值不能等于fast
        //LinkedNode<T> slow = root.getNext();
        LinkedNode<T> slow = root;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return slow;
            }
            slow = slow.getNext();
            fast = fast.getNext();
            if (fast != null) {
                fast = fast.getNext();
            }
        }
        return null;
    }

    // 获取环的入口节点
    public static <T> LinkedNode<T> getEntryNodeOfLoop(LinkedNode<T> root) {
        LinkedNode<T> meetingNode = getMeetingNode(root);
        if (meetingNode == null) {
            return null;
        }
        int count = 1;
        LinkedNode<T> tmp = meetingNode;
        while (tmp.getNext() != meetingNode) {
            count++;
            tmp = tmp.getNext();
        }
        LinkedNode<T> firstIndex = root;
        for (int i = 0; i < count; i++) {
            firstIndex = firstIndex.getNext();
        }
        LinkedNode<T> twoIndex = root;
        while (firstIndex != twoIndex) {
            firstIndex = firstIndex.getNext();
            twoIndex = twoIndex.getNext();
        }
        return twoIndex;
    }

    //获取单链表（可能存在环）中节点数
    public static <T> int getNodeCount(LinkedNode<T> root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        LinkedNode<T> tmp = root;
        LinkedNode<T> meetingNode = getMeetingNode(root);
        //无环
        if (meetingNode == null) {
            while (tmp.getNext() != null) {
                count++;
                tmp = tmp.getNext();
            }
        } else {
            // 方法1.从root开始遍历，使用list存储已遍历的节点
            List<LinkedNode<T>> nodeList = new ArrayList<>();
            nodeList.add(root);
            while (nodeList.indexOf(tmp.getNext()) == -1) {
                count++;
                tmp = tmp.getNext();
                nodeList.add(tmp);
            }

            //方法2.找出入口节点，得到环内节点数、环以外节点数
        }
        return count;
    }
}