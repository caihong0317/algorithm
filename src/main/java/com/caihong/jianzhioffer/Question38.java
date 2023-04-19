package com.caihong.jianzhioffer;

// 字符串排序
public class Question38 {
    public static void main(String[] args) {
        String str1 = null;
        String str2 = "a";
        String str3 = "abc";
        print(str1); // null
        print(str2); //a
        print(str3); // abc acb bac bca cba cab
    }

    public static void permutation(String str) {
        if (str == null || str.length() < 2) {
            System.out.println(str);
        } else {
            permutation(str.toCharArray(), 0);
        }
        System.out.println();
    }

    // index为首位元素
    private static void permutation(char[] array, int index) {
        if (index == array.length - 1) {
            System.out.print(new String(array) + " ");
        }
        char tmp;
        for (int i = index; i < array.length; i++) {
            // 交换（包含和自身）
            tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
            permutation(array, index + 1);

            //还原首位元素
            array[i] = array[index];
            array[index] = tmp;
        }
    }

    public static void print(String str) {
        if (str == null || str.length() < 2) {
            System.out.println(str);
            return;
        }
        replace(str.toCharArray(), 0);
    }

    public static void replace(char[] array, int index) {
        if (index == array.length) {
            System.out.println(new String(array));
        }
        char temp;
        for (int i = index; i < array.length; i++) {
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
            replace(array, index + 1);
            array[i] = array[index];
            array[index] = temp;
        }
    }
}