package com.caihong.algorithm.hashtable;

import java.util.Random;

public class StringHashFamily implements HashFamily<String> {
    private final int[] FUNCTIONS;
    private static final Random RANDOM = new Random();

    // 15个素数
    private static final int[] primeArray = new int[]{17, 19, 23, 29, 31, 37, 41, 43, 47, 53,59, 61, 67, 71, 73};

    public StringHashFamily(int num) {
        FUNCTIONS = new int[num];
        generateNewFunctions();
    }

    @Override
    public int hash(String x, int which) {
        final int MULTIPLIER = FUNCTIONS[which];
        int hashVal = 0;
        if (x != null) {
            for (int i = 0; i < x.length(); i++) {
                hashVal = MULTIPLIER * hashVal + x.charAt(i);
            }
        }
        return hashVal;
    }

    @Override
    public int getNumberOfFunctions() {
        return FUNCTIONS.length;
    }

    @Override
    // 生产哈希函数
    public void generateNewFunctions() {
        // 0表示可用，1表示不可用
        int[] marker = new int[15];
        for (int i = 0; i < FUNCTIONS.length;) {
            //避免重复选中
            int index = RANDOM.nextInt(primeArray.length + 1);
            if (marker[index]==0){
                FUNCTIONS[i] = primeArray[index];
                marker[index]=1;
                i++;
            }
        }
    }
}
