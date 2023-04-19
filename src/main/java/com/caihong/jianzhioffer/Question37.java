package com.caihong.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

// 二叉树的序列化和反序列化
public class Question37 {
    public static void main(String[] args) {
        BinaryTree seven = new BinaryTree(16, null, null);
        BinaryTree six = new BinaryTree(12, null, null);
        BinaryTree five = new BinaryTree(8, null, null);
        BinaryTree four = new BinaryTree(4, null, null);
        BinaryTree three = new BinaryTree(14, six, seven);
        BinaryTree two = new BinaryTree(6, four, five);
        BinaryTree root = new BinaryTree(10, two, three);

        List<Integer> list = new ArrayList<>();
        serialize(root, list);
        System.out.println(list.toString()); // [10, 6, 4, null, null, 8, null, null, 14, 12, null, null, 16, null, null]
        BinaryTree tree = null;
        deserialize(list, 0, tree);
        BinaryTree.prePrintBinaryTree(tree); //
    }

    // 前序遍历序列化
    public static void serialize(BinaryTree tree, List<Integer> list) {
        if (tree == null) {
            list.add(null);
            return;
        }
        list.add(tree.value);
        serialize(tree.left, list);
        serialize(tree.right, list);
    }

    public static void preIterate(BinaryTree tree, List<Integer> list) {
        if (tree == null) {
            list.add(null);
            return;
        }
        list.add(tree.value);
        preIterate(tree.left, list);
        preIterate(tree.right, list);
    }

    // 逐个节点去反序列化
    private static void deserialize(List<Integer> list, int index, BinaryTree tree) {
        if (list == null) {
            return;
        }
        while (index < list.size()) {
            Integer number = list.get(index);
            if (number != null) {
                tree = new BinaryTree();
                tree.value = number;
                // todo 什么时候结束
                deserialize(list, index+1, tree.left);
                deserialize(list, index+1, tree.right);
            }
            index++;
        }
    }
}