package com.caihong.algorithm.SequentialLine;

/**
 * 顺序表实现
 *  方法实现并不合理，入参都有SLType，却又不是静态方法；导致用自己去操作自己
 *   方法不全，没有扩容和迭代
 */
public class SLType {
    static final int MAXSIZE = 16;
    static final int INITSIZE = 8;
    Data[] list = new Data[INITSIZE];
    int length;

    public void initList(SLType slType) {
        slType.length = 0;
    }

    int getLength(SLType slType) {
        return slType.length;
    }

    //插入数据
    boolean insert(SLType slType, int index, Data data) {
        //已满
        //index不合法
        if (index < 0 || index > slType.length) {
            return false;
        }
        for (int i = slType.length; i >= index; i--) {
            slType.list[i + 1] = slType.list[i];
        }
        slType.list[index] = data;
        slType.length++;
        return true;
    }

    //追加
    boolean add(SLType slType, Data data) {
        slType.list[++slType.length] = data;
        return true;
    }

    //删除
    Data delete(SLType slType, int index) {
        Data data = slType.list[index];
        if (index < 0 || index > slType.length) {
            return null;
        }
        for (int i = index; i < slType.length; i++) {
            slType.list[i] = slType.list[i + 1];
        }
        slType.length--;
        return data;
    }

}
