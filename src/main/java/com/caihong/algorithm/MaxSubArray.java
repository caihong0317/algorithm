package com.caihong.algorithm;

//求最大子序列和
public class MaxSubArray {

    public static void main(String[] args) {
        int[] array = {4, -3, 5, -2, -1, 2, 6, -2};  //11
        int maxNum = 0;
        long start = System.currentTimeMillis();
        //这样测试不合理，问题规模依然是N=8
  /*      for (int i = 0; i < 1000; i++) {
//        maxNum = maxSub1(array);
//        maxNum = maxSub2(array);
//        maxNum = maxSub3(array,0,array.length-1);
            maxNum = maxSub4(array);//
        }*/

//        maxNum = maxSub1(array);
//        maxNum = maxSub2(array);
        maxNum = maxSub3(array,0,array.length-1);
//        maxNum = maxSub4(array);//
        long end = System.currentTimeMillis();
        System.out.println(maxNum); //11
        System.out.println(end - start);
    }

    //3层for,O(N^3)
    public static int maxSub1(int[] array) {
        int maxNum = 0;
        int k, j;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            //在i固定时,向前推进一位
            for (j = i; j < length; j++) {
                int thisNum = 0;
                //求和
                for (k = i; k < j; k++) {
                    thisNum += array[k];
                }
                if (thisNum > maxNum) {
                    maxNum = thisNum;
                }
            }
        }
        return maxNum;
    }

    //2层for,O(N^2)
    public static int maxSub2(int[] array) {
        int maxNum = 0;
        int i, j;
        int length = array.length;
        for (i = 0; i < length; i++) {
            //在i固定时,向前推进一位
            int thisNum = 0;
            for (j = i; j < length; j++) {
                thisNum += array[j];
                if (thisNum > maxNum) {
                    maxNum = thisNum;
                }
            }
        }
        return maxNum;
    }

    //分治法,O(N*logN)
    public static int maxSub3(int[] array, int left, int right) {
        //  sic case
        if (left == right) {
            if (left > 0) {
                return left;
            } else {
                return 0; //题目要求
            }
        }

        //计算左右子集
        int maxLeftSubNum, maxRightSubNum;
        int center = (left + right) / 2;
        maxLeftSubNum = maxSub3(array, left, center);
        maxRightSubNum = maxSub3(array, center + 1, right);

        //计算中部跨子集
        int leftNum = 0, rightNum = 0, tempNum1 = 0, tempNum2 = 0;
        for (int i = center; i >= left; i--) {
            tempNum1 += array[i];
            if (tempNum1 > leftNum) {
                leftNum = tempNum1;
            }
        }
        for (int j= center+1; j <= right; j++) {
            tempNum2 += array[j];
            if (tempNum2 > rightNum) {
                rightNum = tempNum2;
            }
        }

        return findMax(maxLeftSubNum, maxRightSubNum, leftNum + rightNum);
    }

    //求3个数中最大者
    private static int findMax(int num1, int num2, int num3) {
        int maxNum = num1;
        if (maxNum < num2) {
            maxNum = num2;
            if (maxNum < num3) {
                maxNum = num3;
            }
        }
        return maxNum;
    }

    //聪明算法，O(N)
    public static int maxSub4(int[] array) {
        int maxNum = 0, tempNum = 0;
        for (int i = 0; i < array.length; i++) {
            //连续前个N负数会被忽略
            if (array[i] <= 0 && maxNum == 0) {
                continue;
            }
            tempNum += array[i];

            //一次循环中两个if只会执行一个
            if (tempNum > maxNum) {
                maxNum = tempNum;
            }
            if (tempNum < 0) {
                tempNum = 0;
            }
        }
        return maxNum;
    }

}
