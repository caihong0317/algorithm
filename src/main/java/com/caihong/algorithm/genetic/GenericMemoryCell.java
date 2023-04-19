package com.caihong.algorithm.genetic;

import java.util.Comparator;

//Java泛型
public class GenericMemoryCell<T> {
    private T storedValue;

    public void write(T value) {
        storedValue = value;
    }

    public T read() {
        return storedValue;
    }

    /*
        泛型方法：此处写<AnyType>或<T>都行
        写<AnyType>时与类泛型一致
        写<T>时不受类泛型限制
     */
    public <T> boolean contains(T[] array, T x) {
        for (T anyType : array) {
            if (x.equals(anyType)) {
                return true;
            }
        }
        return false;
    }

    //'contains(T[], T)' clashes with 'contains(AnyType[], AnyType)'; both methods have same erasure
    public boolean contains2(T[] array, T x) {
        for (T anyType : array) {
            if (x.equals(anyType)) {
                return true;
            }
        }
        return false;
    }

    /*
    只有在AnyType是Comparable的情况下才能保证对compareTo()调用合法
    有以下写法：最后一种最佳
             <AnyType extends Comparable>
             <AnyType extends Comparable<AnyType>>
             <AnyType extends Comparable<? super AnyType>>
     */
    public static <AnyType extends Comparable<? super AnyType>> AnyType findMax(AnyType[] array) {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(array[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return array[maxIndex];
    }

    public static <T> T findMax(T[] array, Comparator<? super T> comparator) {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (comparator.compare(array[i], array[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return array[maxIndex];
    }
}
