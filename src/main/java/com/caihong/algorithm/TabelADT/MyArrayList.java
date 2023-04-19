package com.caihong.algorithm.TabelADT;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayList<AnyType extends Comparable<? super AnyType>> implements Iterable<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private AnyType[] items; // 只声明

    private static final int NOT_FIND = -1;

    // 初始化
    public MyArrayList() {
        doClear();
    }

    public MyArrayList(int initCapacity) {
        size = 0;
        ensuerCapacity(initCapacity);
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        size = 0;
        ensuerCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensuerCapacity(size());
    }

    // 获取
    public AnyType get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[index];
    }

    //
    public int get(AnyType x) {
        if (x == null) {
            return NOT_FIND;
        }
        for (int i = 0; i < size; i++) {
            if (x.compareTo(items[i]) == 0) {
                return i;
            }
        }
        return NOT_FIND;
    }

    //
    public AnyType set(int index, AnyType x){
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType item = items[index];
        items[index]=x;
        return item;
    }

    //
    public boolean add(AnyType x){
        return add(size, x);
    }

    // 声明index从0开始
    public boolean add(int index, AnyType x) {
        if (items.length==size()) {
            ensuerCapacity(size()*2+1);
        }
        // 在末尾添加
        if (index == items.length) {
            items[index]=x;
        }
        for (int i = items.length; i > index ; i--) {
            items[i]=items[i-1];
        }
        items[index]=x;
        size++;
        return true;
    }

    //
    public AnyType remove(int index){
        AnyType item = items[index];
        for (int i = index; i <size()-1; i++) {
            items[i]=items[i+1];
        }
        size--;
        return item;
    }
    // 扩容
    private void ensuerCapacity(int newCapacity) {
        if (newCapacity <= size) {
            return;
        }
        AnyType[] old = items;
        items = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            items[i] = old[i];
        }


    }

    // 返回迭代器
    public java.util.Iterator<AnyType> iterator1(){
        //为什么报错
        return new ArrayListIterator();
    }

  //内部类，可直接访问size和items
     private class ArrayListIterator implements Iterator<AnyType>{

        private int current=0;
        public ArrayListIterator(){
        }
        @Override
        public boolean hasNext() {
            return current<size;
        }

        @Override
        public AnyType next() {
            return items[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

        @Override
        public void forEachRemaining(Consumer<? super AnyType> action) {

        }
    }

    //嵌套类
    private static class  ArrayListIterator1<AnyType extends Comparable<? super AnyType>> implements Iterator<AnyType>{

        private int current=0;
        private MyArrayList<AnyType> list;

        public ArrayListIterator1(MyArrayList<AnyType> list){
            this.list = list;
        }
        @Override
        public boolean hasNext() {
            return current<list.size;
        }

        @Override
        public AnyType next() {
            return list.items[current++];
        }

        @Override
        public void remove() {
            list.remove(--current);
        }

        @Override
        public void forEachRemaining(Consumer<? super AnyType> action) {
        }
    }

    @Override
    public void forEach(Consumer<? super AnyType> action) {

    }

    @Override
    public Spliterator<AnyType> spliterator() {
        return null;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return null;
    }
}
