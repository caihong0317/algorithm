package com.caihong.algorithm;

public class Recursion {
    static int[] array = new int[2];

    public static void main(String[] args) {
//        printNum(76532);

    }
    //bad(1)=bad(1),false
    public static int badLoop(int n){
        if (n==0) {
            return 0;
        }
        return badLoop(n/3+1)+n-1;
    }

    //打印数字
    public static void printNum(int num){
        if(num>=10){
            printNum(num/10);
        }
        System.out.println(num%10);
    }


}
