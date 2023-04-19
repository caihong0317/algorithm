package com.caihong.jianzhioffer;

public class SortAge {

    public void sortAge(int[] ages) {
        if (ages == null || ages.length == 0) {
            return;
        }
        int length = ages.length;
        if (length < 100) {
            // 其他排序方式

        }
        int[] buckets = new int[100];
        for (int i = 0; i < length; i++) {
            buckets[ages[i]] += 1;
        }
        //回填
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                ages[index++] = i;
            }
        }
    }
}