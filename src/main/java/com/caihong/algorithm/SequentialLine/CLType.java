package com.caihong.algorithm.SequentialLine;

// 单链表
public class CLType {
    Data nodeData;
    CLType nextNode;

    boolean add(Data data) {
        CLType clType = new CLType();
        CLType temp = this;
        //内存
        if (clType == null) {
            return false;
        } else {
            clType.nodeData = data;
            clType.nextNode = null;
            //找最后节点
            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = clType;
            return true;
        }
    }

    boolean addFirst(CLType head, Data data) {
        CLType clType = new CLType();
        //内存
        if (clType == null) {
            return false;
        } else {
            clType.nodeData = data;
            clType.nextNode = head;
            //找最后节点
            head = clType;
            return true;
        }
    }

    //查找
    CLType findByKey(String key) {
        CLType clType = this;
        while (clType.nextNode != null) {
            if (clType.nodeData.key.compareTo(key) == 0) {
                return clType;
            } else {
                clType = clType.nextNode;
            }
        }
        return null;
    }

    boolean insert(String key, Data data) {
        CLType clType = new CLType();
        CLType temp = findByKey(key);
        if (temp != null) {
            clType.nodeData = nodeData;
            clType.nextNode = temp.nextNode;
            temp.nextNode = clType;
            return true;
        }
        return false;
    }
}

