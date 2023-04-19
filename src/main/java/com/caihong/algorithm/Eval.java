package com.caihong.algorithm;

public class Eval {

    public static double eval(int n){
        if (n==0) {
            return 1.0;
        }else {
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                sum+=eval(i);
            }
            return 2*sum/n+n;
        }
    }
    
    public static double eval2(int n){
        double[] temp = new double[n+1];
        temp[0]=1.0;
        for (int i = 1; i < n; i++) {
            double sum =0.0;
            for (int j = 0; j < i; j++) {
                sum+=temp[j];
            }
            temp[i]=2*sum/i+i;
        }
        return temp[n];
    }
}
