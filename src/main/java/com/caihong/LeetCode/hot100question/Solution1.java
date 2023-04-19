package com.caihong.LeetCode.hot100question;

import java.util.HashMap;
import java.util.Map;

// 力拓算法题
public class Solution1 {

    // 1、两数之和,因为要索引，所以双层for
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int a;
        for (int i = 0; i < nums.length; i++) {
            a = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (a == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    // 1、两数之和,因为要索引，所以双层for
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        int a, i, j = 0;
        lable:
        for (i = 0; i < nums.length; i++) {
            a = target - nums[i];
            for (j = i + 1; j < nums.length; j++) {
                if (a == nums[j]) {
                    break lable;
                }
            }
        }
        // 此处赋值有问题
        result[0] = i;
        result[1] = j;
        return result;
    }

    // 1、两数之和,因为要索引，所以双层for
    public int[] twoSum3(int[] nums, int target) {
        int[] result = new int[2];
        int a, i, j = 0;
        boolean flag = true;
        for (i = 0; i < nums.length && flag; i++) {
            a = target - nums[i];
            for (j = i + 1; j < nums.length; j++) {
                if (a == nums[j]) {
                    flag = false;
                    break;
                }
            }
        }
        if (!flag) {
            result[0] = i;
            result[1] = j;
            return result;
        }
        return null;
    }

    public int[] twoSum4(int[] nums, int target) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer other = numToIndexMap.get(target - num);
            if (other != null) {
                return new int[]{other, i};
            } else {
                numToIndexMap.put(num, i);
            }
        }
        return new int[2];
    }
}
