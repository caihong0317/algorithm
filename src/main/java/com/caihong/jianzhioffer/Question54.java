package com.caihong.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

//数组中数值和下标相等的元素
public class Question54 {

    public static void main(String[] args) {
        BinaryTree seven = new BinaryTree(8, null, null);
        BinaryTree six = new BinaryTree(6, null, null);
        BinaryTree five = new BinaryTree(4, null, null);
        BinaryTree four = new BinaryTree(2, null, null);
        BinaryTree three = new BinaryTree(7, six, seven);
        BinaryTree two = new BinaryTree(3, four, five);
        BinaryTree root = new BinaryTree(5, two, three);
        System.out.println(getKthMaxNodeInBinarySearchTree(root, 2)); //3
        System.out.println(getKthMaxNodeInBinarySearchTree(root, 4)); //5
        System.out.println(getKthMaxNodeInBinarySearchTree(root, 7)); //8
    }

    // 2、 二分查找,O(logN),边界条件不好写，可用循环而不用递归
    private static BinaryTree getKthMaxNodeInBinarySearchTree(BinaryTree root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>(1);
        list.add(k);
        return getKthMaxNode(root, list);
    }

    // result在左子树、为root或者在右子树。k值如何传递？第二个参数为int时，不能自存储
    private static BinaryTree getKthMaxNode(BinaryTree root, List<Integer> list) {
        BinaryTree result = null;
        if (root.left != null) {
            result = getKthMaxNode(root.left, list);
        }
        if (result == null) {
            if (list.get(0) == 1) {
                return root;
            }
            list.add(0, list.get(0) - 1);
        }
        if (result == null && root.right != null) {
            result = getKthMaxNode(root.right, list);
        }
        return result;
    }
}