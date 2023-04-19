package com.caihong.javathinking.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ListTest {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            testArrayList();
        }
        long time1 = System.currentTimeMillis() - start1;

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            testLinkedList();
        }
        long time2 = System.currentTimeMillis() - start2;
        System.out.println("time1: " + time1);
        System.out.println("time2: " + time2);
        System.out.println((double) time2 / time1);
//        testMap();
    }

    private static void testArrayList() {
        List<Integer> arrayList = new ArrayList<>(100);
        for (int i = 2; i < 100; i++) {
            arrayList.add(i);
        }
        arrayList.removeIf(integer -> !isPrime(integer));
    }

    private static void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 2; i < 100; i++) {
            linkedList.add(i);
        }
        linkedList.removeIf(integer -> !isPrime(integer));
    }

    private static boolean isPrime(int size) {
        for (int i = 3; i <= Math.sqrt(size); i++) {
            if (size % i == 0) {
                return false;
            }
        }
        return true;
    }

/*
    public static void testMap() {
        // 容量为8
        Map<Integer, Integer> map = new HashMap<>(7);
        for (int i = 0; i < 4; i++) {
            map.put(i, i);
        }
        map.put(9, 9);
        System.out.println(map);
    }
*/
}