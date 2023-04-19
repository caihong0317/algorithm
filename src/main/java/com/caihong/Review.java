package com.caihong;

import java.io.File;
import java.nio.file.Files;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class Review {
    {
        System.out.println(2);
    }
    static {
        System.out.println(3);
    }

    public Review() {
        System.out.println(5);
    }

    public static void main(String[] args) {
        Integer integer = new Integer(5);
        System.out.println(integer instanceof Number);

/*
        System.out.println(1);
        Review review = new Review();
        System.out.println(4);
        System.exit(1); // 3 1 2 5 4
*/
/*
        System.out.println(Math.round(-1.5));
        System.out.println(Math.round(-1.6));//-2
 */

//        testPowerTwo();
        testSystem();
    }

    private static void testPowerTwo() {
        int n=9;
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
        n = (n + 1) << 1;
        System.out.println(n);
    }

    public static void testSystem(){
        Map<String, String> getenv = System.getenv();
        for (Map.Entry<String, String> entry : getenv.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
        System.out.println("-----------");

        Properties properties = System.getProperties();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }
}
