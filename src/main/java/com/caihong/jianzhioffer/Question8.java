package com.caihong.jianzhioffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 查找二叉树下一节点
public class Question8 {

    public static void main(String[] args) {
        // 构建树
        BinaryTree one = new BinaryTree(1, null, null, null);
        BinaryTree two = new BinaryTree(2, null, null, one);
        BinaryTree three = new BinaryTree(3, null, null, one);
        one.left=two;
        one.right=three;
        BinaryTree four = new BinaryTree(4, null, null, two);
        BinaryTree five = new BinaryTree(5, null, null, two);
        two.left=four;
        two.right=five;
        BinaryTree six = new BinaryTree(6, null, null, three);
        BinaryTree seven = new BinaryTree(7, null, null, three);
        three.left=six;
        three.right=seven;
        BinaryTree eight = new BinaryTree(8, null, null, five);
        BinaryTree nine = new BinaryTree(9, null, null, five);
        five.left=eight;
        five.right=nine;

        System.out.println(getNextNode(two)); // 8
        System.out.println(getNextNode(six)); // 3
        System.out.println(getNextNode(nine)); // 1
        System.out.println(getNextNode(seven)); //null
    }

    //找出中序的下一节点
    public static BinaryTree getNextNode(BinaryTree node) {
        if (node==null) {
            return null;
        }
        BinaryTree nextNode=null;
        if (node.right!=null) {
            BinaryTree right = node.right;
            while (right.left!=null){
                right=right.left;
            }
            nextNode=right;
        }else if (node.father!=null){
            BinaryTree father = node.father;
/*            if (node== father.left) {
                nextNode=father;
            }*/
            while (father!=null &&node==father.right){
                node=father;
                father=father.father;
            }
            nextNode=father;
        }
        return nextNode;
    }
}