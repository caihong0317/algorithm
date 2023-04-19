package com.caihong.effectivejava;

import java.math.BigDecimal;

public class NoUseFloat {
    public static void main(String[] args) {
//        System.out.println(1.0 - 0.1); //0.9
//        System.out.println(1.0 - 0.1 * 9); // 0.09999999999999998
        buyCandy(); // 4: 0.00
        buyCandy1();
    }

    public static void buyCandy() {
        final BigDecimal tenCents = new BigDecimal("0.10");
        int count = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = tenCents; funds.compareTo(price) >= 0; price = price.add(tenCents)) {
            funds = funds.subtract(price);
            count++;
        }
        System.out.println(count + ": " + funds);
    }

    public static void buyCandy1() {
        final int tenCents = 10;
        int count = 0;
        int funds = 100;
        for (int price = tenCents; funds >= price; price += 10) {
            funds -= price;
            count++;
        }
        System.out.println(count + ": " + funds);
    }
}
