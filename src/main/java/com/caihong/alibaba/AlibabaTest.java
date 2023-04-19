package com.caihong.alibaba;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlibabaTest {
    public static void main(String[] args) {
        /*SeasonEnum spring = SeasonEnum.valueOf(SeasonEnum.class,"SPRING");
        System.out.println(spring.name());
        System.out.println(spring.ordinal()); // 从0开始
        System.out.println(spring.toString());

        System.out.println(spring.equals(SeasonEnum.SUMMER));
        System.out.println(spring.compareTo(SeasonEnum.SUMMER));

        for (SeasonEnum seasonEnum : SeasonEnum.values()) {
            System.out.println(seasonEnum.getSeason());
        }

        testTwo();*/

    }

    public void testOne(String name, int... ids) {
        int length = ids.length;
        int one = ids[0];
        for (int id : ids) {

        }
        
        int tradeId = 001;
        String key = "id_" + tradeId;//不合规

    }

    @Test
    public void testTwo() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a==b); // false

        Float x = Float.valueOf(a);
        Float y = Float.valueOf(b);
        System.out.println(x.equals(y)); // false

        float diff = 1e-6f;
        System.out.println(Math.abs(a-b)<diff); // true

        /*BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");
        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);
        if (x.equals(y)) {
            System.out.println("true");
        }*/
    }

    @Test
    public void testSplit(){
        String name = "boo:andfoo";
        String[] split = name.split("o");
        System.out.println(Arrays.toString(split));
        String[] split1 = name.split("o", 2);
        System.out.println(Arrays.toString(split1));
        String[] split2 = name.split("o", 0);
        System.out.println(Arrays.toString(split2));
        String[] split3 = name.split("o", -1);
        System.out.println(Arrays.toString(split3));
        /*
        [b, , :andf]
        [b, o:andfoo]
        [b, , :andf]
        [b, , :andf, , ]

         */

/*
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat week = new SimpleDateFormat("YYYY");
*/
    }

    @Test
    public void testToArray(){
        System.out.println(new Object().getClass());
        List<String> list = new ArrayList<>(3);
        list.add("a");
        list.add("b");
        list.add("c");
        Object[] objects = list.toArray();
        System.out.println(objects.getClass()); //class [Ljava.lang.Object;
        System.out.println(Arrays.toString(objects)); //[a, b, c]
//        String[] strings = list.toArray(new String[]{});

        String[] strings = list.toArray(new String[0]);//[a, b, c]
        System.out.println(Arrays.toString(strings));

        String[] strings2 = {"d", "d", "d", "d", "d", "d"};
        String[] strings1 = list.toArray(strings2);
        System.out.println(Arrays.toString(strings1)); //[a, b, c, null, d, d]

    }
}
