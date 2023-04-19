package com.caihong.algorithm.genetic;

//Java1.5之前使用Object实现泛型作用
public class MemoryCell {

    private Object storedValue;

    public void write(Object value){
        storedValue=value;
    }
    public Object read(){
        return storedValue;
    }

    //find max
    public static Comparable findMax(Comparable[] array){
        int maxIndex=0;
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(array[maxIndex]) >0) {
                maxIndex=i;
            }
        }
        return array[maxIndex];
    }

    // <AnyType>没有在类上声明时此处必须声明；如在类上声明了AnyType，此处可直接使用；也可声明其他类型变量
    //调用时指定类型
    public <AnyType> boolean contains(AnyType[] array, AnyType x){
        for (AnyType anyType : array) {
            if (x.equals(anyType)) {
                return true;
            }
        }
        return false;
    }

}
