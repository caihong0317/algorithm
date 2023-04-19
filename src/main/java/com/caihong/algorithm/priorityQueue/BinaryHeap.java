package com.caihong.algorithm.priorityQueue;

import java.util.NoSuchElementException;

//min二叉堆（元素可重复）
public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
    private int currentSize;
    private AnyType[] array;

    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        int newCapacity = capacity > DEFAULT_CAPACITY ? capacity : DEFAULT_CAPACITY + 1;
        array = (AnyType[]) new Object[newCapacity];
    }

    // 方式1
    public BinaryHeap(AnyType[] items) {
        array = (AnyType[]) new Object[items.length*2 + 1];
        for (AnyType item : items) {
            if (item != null) {
                insert(item);
            }
        }
    }

    // 方式2
   /*
   public BinaryHeap(AnyType[] items) {
        enlargeSize(items);
        buildHeap();
    }*/

    public void insert(AnyType x) {
        if (currentSize == array.length - 1) {
            enlargeSize(array);
        }
        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }

    public AnyType findMin() {
        return array[1];
    }

    public AnyType deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }
        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public void makeEmpty() {
        for (AnyType anyType : array) {
            anyType = null;
        }
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    private void percolateDown(int hole) {
        int child;
        AnyType tmp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }

    private void buildHeap() {
        for (int i = currentSize/2; i >0; i--) {
            percolateDown(i);
        }
    }

    private void enlargeSize(AnyType[] items) {
        AnyType[] oldArray =items;
        array= (AnyType[]) new Object[items.length*2+1];
        int i=1;
        for (AnyType item : items) {
            array[i++]=item;
      }
    }

    // 假设实现，给回溯重建大桥使用 start
    public AnyType deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }
        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public boolean contains(AnyType x){
        for (AnyType anyType : array) {
            if (anyType==null) {
                if (x==null) {
                    return true;
                }
            }else {
                if (anyType.compareTo(x)==0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void remove(AnyType x){
        // 删除任意节点后，需重新构建堆
    }

    public AnyType findMax() {
        return array[1];
    }
    // 假设实现，给回溯重建大桥使用  end

}
