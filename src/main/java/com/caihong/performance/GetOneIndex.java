package com.caihong.performance;

public class GetOneIndex {
    public static void main(String[] args) {
        String index = getIndex(0b1010110);
        System.out.println(index); // 1,2,4,6
        System.out.println(getIndex(0b11111)); // 0,1,2,3,4
    }

    public static String getIndex(int num) {
        StringBuilder builder = new StringBuilder();
        int base = 2;
        int i = 0;
        while (true) {
            int pow = (int) Math.pow(2, i);
            if (num >= pow) {
                if ((num & pow) != 0) {
                    builder.append(i).append(",");
                }
                i++;
            } else {
                break;
            }
        }
        return builder.substring(0, builder.length() - 1);
    }
}
