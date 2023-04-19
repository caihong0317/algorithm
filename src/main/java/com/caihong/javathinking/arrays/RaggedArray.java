package com.caihong.javathinking.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RaggedArray {
    private static final Random RANDOM = new Random(47);
/*
    public static void main(String[] args) {
        int[][][] array=new int[RANDOM.nextInt(7)][][];
        for (int i = 0; i < array.length; i++) {
            array[i]=new int[RANDOM.nextInt(5)][];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]=new int[RANDOM.nextInt(5)];
            }
        }
        System.out.println(Arrays.deepToString(array));
    }
*/

    public static void main(String[] args) {
        Integer[][] array;
        array=new Integer[3][];
        for (int i = 0; i < array.length; i++) {
            array[i]=new Integer[3];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]=(i+1)*(j+1);
            }
        }
        System.out.println(Arrays.deepToString(array)); // [[1, 2, 3], [2, 4, 6], [3, 6, 9]]
    }

    @SuppressWarnings("unchecked")
    public <T> T[] f(int size){
        // T[] ts = new T[size]; // 报错
        List<String>[] array;
        List[] lists = new List[10];
        array=(List<String>[])lists;
        array[0]=new ArrayList<String>();
//        array[0]=new ArrayList<Integer>();
        Object[] objs=array;
        objs[1]=new ArrayList<Integer>();
        return (T[]) new Object[size];
    }

    public <T> void fill(T[] array, T t){
        Arrays.fill(array, t);
    }
}