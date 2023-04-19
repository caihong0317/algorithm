package com.caihong.jianzhioffer;

// 复制复杂链表
public class Question36 {
    public static void main(String[] args) {
        BinaryTree seven = new BinaryTree(16, null, null);
        BinaryTree six = new BinaryTree(12, null, null);
        BinaryTree five = new BinaryTree(8, null, null);
        BinaryTree four = new BinaryTree(4, null, null);
        BinaryTree three = new BinaryTree(14, six, seven);
        BinaryTree two = new BinaryTree(6, four, five);
        BinaryTree root = new BinaryTree(10, two, three);
        BinaryTree head = convert(root);
        printAfterConvert(head); //4 6 8 10 12 14 16
        BinaryTree head1 = convert(null);
        printAfterConvert(head1); //null
    }

    public static BinaryTree convert(BinaryTree tree) {
        if (tree == null) {
            return null;
        }
        convertNode(tree, null);
        BinaryTree head = tree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static BinaryTree convertNode(BinaryTree root, BinaryTree lastNode) {
        if (root == null) {
            return null;
        }
        BinaryTree current = root;
        if (current.left != null) {
            lastNode = convertNode(current.left, lastNode);
        }
        current.left = lastNode;
        if (lastNode != null) {
            lastNode.right = current;
        }
        lastNode = current;
        if (current.right != null) {
            lastNode = convertNode(current.right, lastNode);
        }
        return lastNode;
    }

    // 中序遍历转为链表后再打印
    public static void printAfterConvert(BinaryTree head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        BinaryTree tmp = head;
        while (tmp != null) {
            System.out.print(tmp.toString());
            tmp = tmp.right;
        }
        System.out.println();
    }
}