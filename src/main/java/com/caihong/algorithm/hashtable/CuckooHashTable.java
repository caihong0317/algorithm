package com.caihong.algorithm.hashtable;

import java.util.Random;

public class CuckooHashTable<AnyType> {

    private static final double LOAD_FACTOR = 0.4;
    private static final int DEFAULT_TABLE_SIZE = 101;
    private static final int ALLOWED_REHASHED = 1;
    private static final int REPLACE_LIMIT = 100;
    private static final int LOOP_LIMIT = 5;
    private static final Random RANDOM = new Random();

    private static final int NOT_FIND = -1;

    private final HashFamily<AnyType> family;
    private int functionNum;
    private AnyType[] array;
    private int currentSize;

    private int rehash = 0;


    public CuckooHashTable(HashFamily<AnyType> family) {
        this(family, DEFAULT_TABLE_SIZE);
    }

    public CuckooHashTable(HashFamily<AnyType> family, int size) {
        // 要求散列函数至少有两个
        if (family == null || family.getNumberOfFunctions() < 2) {
            throw new RuntimeException("HashFamily is null or functionNum is not greater than two");
        }

        if (size <= 0) {
            allocateArray(nextPrime(DEFAULT_TABLE_SIZE));
        } else {
            allocateArray(nextPrime(size));
        }

        this.family = family;
        functionNum = family.getNumberOfFunctions();
        doClear();
    }

    public void makeEmpty() {
        doClear();
    }

    public boolean contains(AnyType x) {
        return findPos(x) != NOT_FIND;
    }

    public boolean remove(AnyType x) {
        int pos = findPos(x);
        if (pos != NOT_FIND) {
            array[pos] = null;
            currentSize--;
        }
        return pos != NOT_FIND;
    }

    public boolean insert(AnyType x) {
        if (contains(x)) {
            return false;
        }
        if (currentSize >= array.length * LOAD_FACTOR) {
            expand();
        }

        return insertHelper(x);
    }

    private boolean insertHelper(AnyType x) {
        while (true) {
            int lastPos = -1;
            int pos;

            for (int count = 0; count < REPLACE_LIMIT; count++) {
                // 找空位插入
                for (int j = 0; j < functionNum; j++) {
                    pos = myHash(x, j);
                    if (array[pos] == null) {
                        array[pos] = x;
                        currentSize++;
                        return true;
                    }
                }

                int i = 0;
                do {
                    pos = myHash(x, RANDOM.nextInt(functionNum));
                } while (pos == lastPos && ++i < LOOP_LIMIT);
                AnyType temp = array[pos];
                array[pos] = x;
                x = temp;
            }

            // 未成功插入，rehash或扩容
            if (++rehash <= ALLOWED_REHASHED) {
                rehash();
            } else {
                expand();
                rehash = 0;
            }
        }
    }

    // 扩容
    private void expand() {
        rehash(nextPrime((int) (array.length / LOAD_FACTOR)));
    }

    //
    private void rehash() {
        family.generateNewFunctions();
        rehash(array.length);
    }

    //
    private void rehash(int newLength) {
        AnyType[] oldArray = array;
        allocateArray(nextPrime(newLength));
        for (int i = 0; i < oldArray.length; i++) {
            if (array[i] != null) {
                insert(array[i]);
            }
        }
        currentSize = 0;
    }

    private int findPos(AnyType x) {
        for (int i = 0; i < functionNum; i++) {
            int pos = myHash(x, i);
            if (array[pos] != null && array[pos].equals(x)) {
                return pos;
            }
        }
        return -1;
    }

    private int myHash(AnyType x, int which) {
        int hashVal = family.hash(x, which);
        hashVal %= array.length;
        if (hashVal < 0) {
            hashVal += array.length;
        }
        return hashVal;
    }


    private void allocateArray(int size) {
        array = (AnyType[]) new Object[size];
    }

    private void doClear() {
        // 似乎不可以
        /*for (AnyType anyType : array) {

        }*/
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
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

