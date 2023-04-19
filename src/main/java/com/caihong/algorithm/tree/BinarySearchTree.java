package com.caihong.algorithm.tree;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    private static class BinaryNode<AnyType> {
        // inner class
        BinaryNode(AnyType element) {
            this(element, null, null);
        }

        BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        AnyType element;
        BinaryNode left;
        BinaryNode right;
    }

    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return findMin(root).element;
    }

    public AnyType findMax() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return findMax(root).element;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    // 删除最复杂
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> root) {
        if (root == null) {
            return root;
        }
        int result = x.compareTo(root.element);
        if (result < 0) {
            root.left = remove(x, root.left);
        } else if (result > 0) {
            root.right = remove(x, root.right);
        } else if (root.left != null && root.right != null) {
            root.element = findMin(root).element;
            root.right = remove(root.element, root.right);
        } else {
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }

    //插入到叶子节点
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> root) {
        if (root == null) {
            return new BinaryNode<>(x, null, null);
        }
        int result = x.compareTo(root.element);
        if (result < 0) {
            root.left = insert(x, root.left);
        } else if (result > 0) {
            root.right = insert(x, root.right);
        } else {
            //相等时不做操作

        }
        return root;
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> root) {
        if (root != null) {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> root) {
        if (root == null) {
            return null;
        } else if (root.left == null) {
            return root;
        } else {
            return findMin(root.left);
        }
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> root) {
        if (root == null) {
            return false;
        }
        int compare = x.compareTo(root.element);
        if (compare < 0) {
            return contains(x, root.left);
        }
        if (compare > 0) {
            return contains(x, root.right);
        }
        return true;
    }

}
