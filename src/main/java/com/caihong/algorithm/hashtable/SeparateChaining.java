package com.caihong.algorithm.hashtable;

import java.util.LinkedList;
import java.util.List;

// 不足，应使用双泛型
// separate chaining
public class SeparateChaining<E> {

    private List<E>[] theLists;
    private int currentSize;
    private static final int DEFAULT_TABLE_SIZE = 11;

    public SeparateChaining() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChaining(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
        currentSize=0;
    }

    // 不允许重复元素
    public void insert(E x) {
        if (!contains(x)) {
            List<E> theList = theLists[myHash(x)];
            theList.add(x);
            if ((++currentSize > theLists.length)) {
                //扩容
                rehash();
            }
        }
    }

    private void rehash() {
        List<E>[] oldList = theLists;
        theLists = new List[nextPrime(oldList.length * 2)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
        currentSize=0;

        for (List<E> list : oldList) {
            for (E e : list) {
                insert(e);
            }
        }
    }

    public void remove(E x) {
        boolean flag = theLists[myHash(x)].remove(x);
        if (flag) {
            currentSize--;
        }
    }

    public boolean contains(E x) {
        return theLists[myHash(x)].contains(x);
    }

    private int myHash(E x) {
        int hashCode = x.hashCode() % theLists.length;
        if (hashCode < 0) {
            hashCode += theLists.length;
        }
        return hashCode;
    }

    public void makeEmpty(E x) {
        for (List<E> theList : theLists) {
            theList.clear();
        }
        currentSize = 0;
    }

    // 于size的最小素数
    private int nextPrime(int size) {
        if (size <= 2) {
            return 2;
        }
        while (!isPrime(size)) {
            size++;
        }
        return size;
    }

    // 素数判断 N,size / 2不合理
    private boolean isPrime(int size) {
        for (int i = 3; i <= Math.sqrt(size); i++) {
            if (size % i == 0) {
                return false;
            }
        }
        return true;
    }
}
