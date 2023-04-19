package com.caihong.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

// 复制复杂链表
public class Question35 {
    public static void main(String[] args) {
        LinkedNode<Integer> linkedNode = new LinkedNode<>();
        LinkedNode<Integer> copyLinkedList = copyLinkedList(linkedNode);
        System.out.println(copyLinkedList);
    }

    // 使用O(n)空间
    public static <T> LinkedNode<T> copyLinkedList(LinkedNode<T> linkedNode) {
        if (linkedNode == null) {
            return null;
        }
        Map<LinkedNode<T>, LinkedNode<T>> hashMap = new HashMap<>();
        LinkedNode<T> node = copyNodes(linkedNode, hashMap);
        setSibling(linkedNode, node, hashMap);
        return node;
    }

    // 复制next
    private static <T> LinkedNode<T> copyNodes(LinkedNode<T> linkedNode, Map<LinkedNode<T>, LinkedNode<T>> map) {
        LinkedNode<T> copyNode = new LinkedNode<>();
        LinkedNode<T> tmp = linkedNode;
        LinkedNode<T> copyTmp = copyNode;
        while (tmp != null) {
            copyTmp.setValue(tmp.getValue());
            copyTmp.setNext(new LinkedNode<>());
            copyTmp.setSibling(null);
            map.put(tmp, copyTmp);
            tmp = tmp.getNext();
            copyTmp = copyTmp.getNext();
        }
        return copyNode;
    }

    // 复制Sibling
    private static <T> void setSibling(LinkedNode<T> linkedNode, LinkedNode<T> copyNodes, Map<LinkedNode<T>, LinkedNode<T>> map) {
        LinkedNode<T> tmp = linkedNode;
        while (tmp != null) {
            if (tmp.getSibling() != null) {
                LinkedNode<T> copyNode = map.get(tmp);
                LinkedNode<T> sibling = tmp.getSibling();
                copyNode.setSibling(map.get(sibling));
            }
            tmp = tmp.getNext();
        }
    }

    // 不使用额外空间
    public static <T> LinkedNode<T> copyLinkedList2(LinkedNode<T> linkedNode) {
        if (linkedNode == null) {
            return null;
        }
        copyNodes2(linkedNode);
        setSibling2(linkedNode);
        LinkedNode<T> copyNode = separate(linkedNode);
        return copyNode;
    }

    private static <T> void copyNodes2(LinkedNode<T> linkedNode) {
        LinkedNode<T> tmp = linkedNode;
        LinkedNode<T> next;
        while (tmp != null) {
            LinkedNode<T> copyNode = new LinkedNode<>();
            copyNode.setValue(tmp.getValue());
            copyNode.setNext(tmp.getNext());
            copyNode.setSibling(null);
            tmp.setNext(copyNode);
            tmp = copyNode.getNext();
        }
    }

    private static <T> void setSibling2(LinkedNode<T> linkedNode) {
        LinkedNode<T> tmp = linkedNode;
        while (tmp != null) {
            if (tmp.getSibling() != null) {
                LinkedNode<T> sibling = tmp.getSibling();
                LinkedNode<T> copyNode = tmp.getNext();
                copyNode.setSibling(sibling.getNext());
            }
            tmp = tmp.getNext();
        }
    }

    // 将链表的奇偶位分离，形成两个链表。可调用通用方法com.caihong.jianzhioffer.LinkedNode.separateOddEven
    private static <T> LinkedNode<T> separate(LinkedNode<T> linkedNode) {
        LinkedNode<T> copyNode = linkedNode.getNext();
        LinkedNode<T> copy = copyNode;
        LinkedNode<T> tmp = copy.getNext();
        linkedNode.setNext(tmp);
        while (tmp != null) {
            copy.setNext(tmp.getNext());
            copy = copy.getNext();
            tmp.setNext(copy.getNext());
            tmp = tmp.getNext();
        }
/*
        LinkedNode<T> tmp1 = linkedNode;
        while (tmp1!=null){
            // 此处应该发现不对劲，去改成上面的写法
            LinkedNode<T> copy1 = tmp1.getNext();
            tmp1.setNext(copy1.getNext());
            tmp1=tmp1.getNext();
        }
*/
        return copyNode;
    }
}